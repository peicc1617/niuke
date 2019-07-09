package SOM.utils;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import SOM.k_means.Cluster;
import SOM.k_means.Cluster;

public class AlgorithmUtils {

	/**
	 * Compute the learning rate which linear decreases: Learning rate has a
	 * bigger value at the beginning and it loses from its value as the number
	 * of iteration grows.
	 * 
	 * @param currentIter
	 *            number of current iteration
	 * @return value of learning rate depending iteration number
	 */
	public static double learningRate(int currentIter) {

		double a, b;

		a = (Constants.STOP_LR - Constants.START_LR) / (Constants.MAX_ITER - 1);
		b = Constants.START_LR - a;

		return a * currentIter + b;
	}

	/**
	 * Compute the neighbourhood radius reported to the iteration index
	 * 
	 * @param currentIter
	 *            index of current iteration
	 * @return value of the radius
	 */
	public static double radius(int currentIter) {
		double toDivide = Constants.MAX_ITER / Constants.RADIUS;
		return Constants.RADIUS * Math.exp(-currentIter / toDivide);
	}

	/**
	 * Find the position of the minimum value from a matrix
	 * 
	 * @param matrix
	 *            the matrix in which the lookup is made
	 * @return coordinates of minimum point
	 */
	public static Point2D matrixMin(double matrix[][]) {
		double min = Double.MAX_VALUE;
		Point2D point = new Point(-1, -1);

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				if (matrix[i][j] != -1 && matrix[i][j] < min) {
					min = matrix[i][j];
					point.setLocation(i, j);
				}
			}

		return point;
	}

	/**
	 * Compute Dunn-index for the obtained clusters
	 * 
	 * @param clusters
	 *            clusters for which the values should be computed
	 * @return Dunn_index
	 */
	public static double dunnIndex(List<Cluster> clusters) {
		double minInterClusterInner = Double.MAX_VALUE;
		double minInterClusterOuter = Double.MAX_VALUE;
		double intraCluster, distance;
		Point3D centroid1, centroid2;

		for (int i = 0; i < clusters.size(); ++i) {
			// intra cluster distance
			intraCluster = clusters.get(i).intraClusterDistance();
			if (intraCluster == 0)
				continue;

			centroid1 = clusters.get(i).getPrevCentroid();

			// minimal inter-cluster distance to maximal intra-cluster distance
			minInterClusterInner = Double.MAX_VALUE;
			for (int j = i + 1; j < clusters.size() - 1; ++j) {
				centroid2 = clusters.get(j).getPrevCentroid();
				distance = centroid1.distance(centroid2);
				if (intraCluster / distance < minInterClusterInner)
					minInterClusterInner = intraCluster / distance;
			}

			if (minInterClusterOuter > minInterClusterInner) {
				minInterClusterOuter = minInterClusterInner;
			}
		}

		return minInterClusterOuter;
	}

	/**
	 * Given centroids of clusters adds the input learning set into the
	 * corresponding clusters
	 * 
	 * @param centroids
	 *            values of centroids
	 * @param learningSet
	 *            input values
	 * @return array containing all the input learning set organized into
	 *         clusters
	 */
	public static List<List<Example>> buildClusters(List<Point3D> centroids,
			ArrayList<Example> learningSet) {
		//System.out.println("No centroids is " + centroids.size());
		List<List<Example>> clusters = new ArrayList<List<Example>>(
				centroids.size());
		Point3D centroid;
		Example learningEx;
		double minDistance, distance;
		int minIdx;

		for (int i = 0; i < centroids.size(); ++i) {
			clusters.add(new ArrayList<Example>());
		}

		for (int j = 0; j < learningSet.size(); ++j) {
			minDistance = Double.MAX_VALUE;
			learningEx = learningSet.get(j);
			//System.out.println("Learning example " + learningEx);
			minIdx = -1;

			for (int i = 0; i < centroids.size(); i++) {
				centroid = centroids.get(i);
				distance = learningEx.coordinate.distance(centroid);
				//System.out.println("Centroid is " + centroid);

				// save the index of the centroid with the smallest distance
				if (distance < minDistance) {
					minIdx = i;
					minDistance = distance;
				}
			}

			// add example to the corresponding cluster
			clusters.get(minIdx).add(learningSet.get(j));

		}

//		for (int i = 0; i < centroids.size(); ++i) {
//			//System.out.println("[cluster] " + i + " [size] "
//					//+ clusters.get(i).size());
//
//		}
		return clusters;
	}

	/**
	 * Evaluate the binomial coefficient
	 */
	public static double combinations(int n, int k) {
		double coeff = 1;
		for (int i = n - k + 1; i <= n; i++) {
			coeff *= i;
		}
		for (int i = 1; i <= k; i++) {
			coeff /= i;
		}
		return coeff;
	}

	/**
	 * Compute sum of false positives and true negatives
	 * @param clusters all the clusters
	 * @return the TP + FP
	 */
	private static double true_false_positive(List<Cluster> clusters) {
		double tp_plus_fp = 0.0;

		for (int i = 0; i < clusters.size(); ++i) {
			tp_plus_fp += combinations(clusters.get(i).getPrevMembers().size(),
					2);
		}

		return tp_plus_fp;
	}
	
	/**
	 * Computes the true_positive value
	 * @param clusters
	 * @return TP
	 */
	private static double true_positive(List<Cluster> clusters) {
		double tp = 0.0;
		Integer freq;
		Cluster cluster;
		Set<String> classNames;
		Iterator<String> className;

		
		for (int i = 0; i < clusters.size(); ++i) {
			cluster = clusters.get(i);
			
			classNames = cluster.classFrequence.keySet();
			className = classNames.iterator();
			
			while (className.hasNext()) {
				freq = cluster.classFrequence.get(className.next());
				if (freq > 1)
					tp += combinations(freq, 2);
			}
		}
		
		return tp;
	}
	
	/**
	 * Compute all the false negative values for clusters
	 * @param clusters all the clusters for which the value should be computed
	 * @return FN
	 */
	public static double false_negative(List<Cluster> clusters) {
		double fn = 0.0;
		Cluster clusterSrc, clusterDst;
		Set<String> classNamesSrc;
		Iterator<String> className;
		String name;
		
		for (int i = 0; i < clusters.size(); i++) {
			clusterSrc = clusters.get(i);
			for (int j = i +1; j < clusters.size() - 1; ++j) {
				clusterDst = clusters.get(j);
				
				classNamesSrc = clusterSrc.classFrequence.keySet();
				className = classNamesSrc.iterator();
				
				while (className.hasNext()) {
					name = className.next();
					if (clusterDst.classFrequence.containsKey(name)) {
						fn = clusterSrc.classFrequence.get(name) * clusterDst.classFrequence.get(name);
					}
				}
				
			}
		}
		
		return fn;
	}

	public static double f_measure(List<Cluster> clusters) {
		double tp_plus_fp = true_false_positive(clusters);
		double tp = true_positive(clusters);
		double fn = false_negative(clusters);
		
		double precision = tp / tp_plus_fp;
		double recall = tp / tp + fn;
	
		return Math.pow(Constants.BETA, 2) * precision * recall / (Math.pow(Constants.BETA, 2) * precision + recall);
	}

}
