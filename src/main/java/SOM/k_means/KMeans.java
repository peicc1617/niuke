package SOM.k_means;

import java.util.ArrayList;
import java.util.List;

import SOM.utils.Constants;
import SOM.utils.Example;
import SOM.utils.Constants;
import SOM.utils.Example;
import SOM.utils.Point3D;

public class KMeans {

	private List<Cluster> clusters;
	private List<Cluster> prevClusters;
	

	public KMeans() {
		clusters = new ArrayList<Cluster>();
	}

	private int initializeClusters(List<Example> means, int noClusters) {
		Cluster tmpCluster;
		KMeansPlusPlus kpp = new KMeansPlusPlus(noClusters);

		// get the initial centroids
		List<Point3D> centroids = kpp.findCentroids(means);
		clusters.clear();
		// initialize each cluster
		for (int i = 0; i < centroids.size(); ++i) {
			tmpCluster = new Cluster();
			tmpCluster.setCentroid(centroids.get(i));
			clusters.add(tmpCluster);
			//System.out.println(clusters.get(i).getCentroid());
		}

		return noClusters;
	}

	/**
	 * Add each mean in the corresponding cluster, according to the distance
	 * from the centroid
	 * 
	 * @param means
	 *            values which should be distributed into clusters
	 */
	private void buildClusters(List<Example> means) {
		Point3D centroid;
		double minDistance, distance;
		int minIdx;

		for (int j = 0; j < means.size(); ++j) {
			minDistance = Double.MAX_VALUE;
			minIdx = -1;

			for (int i = 0; i < clusters.size(); i++) {
				centroid = clusters.get(i).getCentroid();
				distance = means.get(j).coordinate.distance(centroid);

				// save the index of the centroid with the smallest distance
				if (distance < minDistance) {
					minIdx = i;
					minDistance = distance;
				}
			}

			clusters.get(minIdx).getMembers().add(means.get(j));

		}

	}

	/**
	 * Update values of the centroids
	 */
	private void computeCentroids() {
		Point3D centroid;
		Point3D sumPoint;
		List<Example> members;

		for (int i = 0; i < clusters.size(); ++i) {
			centroid = clusters.get(i).getCentroid();
			members = clusters.get(i).getMembers();

			sumPoint = new Point3D();
			
			// compute sum of all members of the cluster
			for (int j = 0; j < members.size(); ++j) {
				sumPoint.add(members.get(j).coordinate);
			}

			// divide each sumPoint with the number or elements in the cluster
			if (members.size() == 0) {
				clusters.get(i).setPrevCentroid(centroid);
				continue;
			}
			
			sumPoint.divideWithScalar(members.size());

			clusters.get(i).setPrevCentroid(centroid);
			clusters.get(i).setCentroid(sumPoint);

			//System.out.println(clusters.get(i).getCentroid());
		}
	}

	/**
	 * Empties the current members and updates the previous members list
	 */
	private void emptyClusters() {
		for (int i = 0; i < clusters.size(); ++i) {
			clusters.get(i).emptyCluster();
		}
	}

	/**
	 * Verify if the kMeans algorithm should be applied again
	 * 
	 * @return true if the algorithm should continue, false otherwise
	 */
	private boolean continueKMeans() {

		for (int i = 0; i < clusters.size(); ++i) {
			// verify if all the clusters achieved a stable level
			if (!clusters.get(i).getCentroid().equals(clusters.get(i).getPrevCentroid()))
				return true;
		}

		return false;
	}

	/**
	 * Compute the distances between all centroids
	 * 
	 * @return minimum distance between 2 centroids
	 */
	private double interClusterDistance() {
		double minDistance = Double.MAX_VALUE;
		double distance;
		Point3D centroid1, centroid2;

		for (int i = 0; i < clusters.size(); ++i) {
			centroid1 = clusters.get(i).getCentroid();
			for (int j = i + 1; j < clusters.size() - 1; ++j) {
				centroid2 = clusters.get(j).getCentroid();
				distance = centroid1.distance(centroid2);

				if (distance < minDistance)
					minDistance = distance;
			}
		}

		return minDistance;
	}

	/**
	 * Find the largest distance inside a cluster
	 * 
	 * @return the maxmimum between all intracluster distances
	 */
	private double intraClusterDistance() {
		double maxDistance = Double.MIN_VALUE;
		double distance;

		for (int i = 0; i < clusters.size(); ++i) {
			distance = clusters.get(i).intraClusterDistance();

			if (distance > maxDistance)
				maxDistance = distance;
		}

		return maxDistance;
	}

	/**
	 * Function which implements the Kmeans algorithm
	 * 
	 * @param means
	 *            all the members that should be put in different clusters
	 */
	public List<Cluster> kMeans(List<Example> means) {
		int noClusters = initializeClusters(means, Constants.INITIAL_NO_CLUSTERS);
		double interClusterDistance = -1, prevInterClusterDistance = -1;
		double intraClusterDistance = -1, prevIntraClusterDistance = -1;
		List<Example> copyMeansList = new ArrayList<Example>();
		
		for (;;) {
			do {
				// clear all current lists of clusters
				emptyClusters();

				// copy the means
				copyMeansList.clear();
				copyMeansList.addAll(means);

				buildClusters(copyMeansList);

				// compute new centroids
				computeCentroids();

			} while (continueKMeans());

			
			// verify if the number of clusters should be modified
			if (prevInterClusterDistance == -1) {
				prevInterClusterDistance = interClusterDistance();
				prevIntraClusterDistance = intraClusterDistance();
			} else {
				/*
				 * distance between the clusters to be bigger, and the intra
				 * cluster distance should be small (points inside a cluster
				 * should be compact)
				 */
				interClusterDistance = interClusterDistance();
				intraClusterDistance = intraClusterDistance();

				if (interClusterDistance >= interClusterDistance
						&& intraClusterDistance <= prevIntraClusterDistance)
					break;
				
				prevInterClusterDistance = interClusterDistance;
				prevIntraClusterDistance = intraClusterDistance;

				// increase the number of clusters
			}
			
			noClusters++;
			prevClusters = new ArrayList<Cluster>();
			prevClusters.addAll(clusters);
			initializeClusters(means, noClusters);
		}

		return prevClusters;
	}
	
	/**
	 * Build a cluster which contains only one element: the centroid
	 * @param elements centroid of the cluster
	 * @return the cluster with no member
	 */
	public Cluster buildSingleCluster(List<Example> elements) {
		Cluster cluster = new Cluster();
		cluster.setCentroid(elements.get(0).coordinate);
		cluster.setPrevCentroid(elements.get(0).coordinate);
		
		return cluster;
	}
}
