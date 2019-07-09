package SOM.som;

import java.util.ArrayList;
import java.util.List;

import SOM.k_means.Cluster;
import SOM.k_means.KMeans;
import SOM.utils.*;
public class Main {

	public static void main(String args[]) {
		List<Point3D> centroids;
		List<Cluster> newClusters = new ArrayList<Cluster>();
		List<Cluster> tmp;
		List<List<Example>> clusters;
		double dunn_index, f_measure;
		int counter;
		InputProcessing inputProcess = new InputProcessing(Constants.FILE);
		KMeans kmeans;
		double x_neurons[]	= new double[Constants.MAX_NEURON_NO - Constants.NEURON_NO + 1];
		double y_dunn[]		= new double[Constants.MAX_NEURON_NO - Constants.NEURON_NO + 1];
		double y_fmeasure[]	= new double[Constants.MAX_NEURON_NO - Constants.NEURON_NO + 1];

		ArrayList<Example> examples = inputProcess.processFile();
		ArrayList<Point3D> points = inputProcess.getCoordinates();

		for (counter = 0; Constants.NEURON_NO <= Constants.MAX_NEURON_NO; Constants.NEURON_NO++, counter++) {
			System.out.println("********* Iteration " + counter + " ***********");
			// inputProcess.printInput(examples);

			SOM.selfOrganizingMaps(points);
			// SOM.displayWeights();

			SOM.buildUmatrix();
			// SOM.displayUmatrix();

			// find centroids from U-Matrix
			centroids = SOM.getAllClusters();

			clusters = AlgorithmUtils.buildClusters(centroids, examples);

			// for every cluster apply K-Means;
			for (int i = 0; i < clusters.size(); ++i) {
				
				kmeans = new KMeans();

				// find subclusters for each cluster
				if (clusters.get(i).size() > 1) {
					tmp = kmeans.kMeans(clusters.get(i));
					newClusters.addAll(tmp);
				} else {
					if (!clusters.get(i).isEmpty())
					newClusters.add(kmeans.buildSingleCluster(clusters.get(i)));
				}
			}

			/* compute dunn_index for all the clusters */
			dunn_index = AlgorithmUtils.dunnIndex(newClusters);

			// compute the frequences of all classes
			for (int i = 0; i < newClusters.size(); ++i) {
				newClusters.get(i).computeFrequences();
			}

			/* compute f_measure for all the clusters */
			f_measure = AlgorithmUtils.f_measure(newClusters);
			
			x_neurons[counter]	= Constants.NEURON_NO;
			y_dunn[counter]		= dunn_index;
			y_fmeasure[counter]	= f_measure;
		}
		//plot the obtained data
		PlotData.plotData(x_neurons, y_dunn, "numar de neuroni", "Dunn index");
		PlotData.plotData(x_neurons, y_fmeasure, "numar de neuroni", "F-measure");
	}
}
