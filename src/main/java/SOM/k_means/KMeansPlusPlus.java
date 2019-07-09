package SOM.k_means;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import SOM.utils.Example;
import SOM.utils.Point3D;

public class KMeansPlusPlus {

	private List<Point3D> centroids;
	private int noCentroids;
	private int nearestIdx;
	
	public KMeansPlusPlus(int noCentroids) {
		this.noCentroids = noCentroids;
		centroids = new ArrayList<Point3D>();
	}
	
	/**
	 * Finds which is the closest centroid for a point
	 * @param mean the point for which the centroid is searched
	 * @return value of the distance
	 */
	private double nearest(Point3D mean) {
		double distance = Double.MAX_VALUE;
		double tmp;
		int idx = 0;
		
		this.nearestIdx = -1;
		
		for (Point3D centroid : centroids) {
			if (!mean.equals(centroid)) {
				tmp = centroid.distance(mean);
				if (tmp * tmp< distance) {
					distance = tmp * tmp;
					this.nearestIdx = idx;
				}
			}
			++idx;
		}
		
		return distance;
	}
	
	/**
	 * Find a given number of centroids 
	 * @param means data for which the centroids should be found
	 * @return array of centroids
	 */
	public List<Point3D> findCentroids(List<Example> means) {
		Random rand = new Random();
		int firstIdx = rand.nextInt(means.size());
		double sum;
		int nearestIdxs[] = new int[means.size()];
		double nearestDist[] = new double[means.size()];
		
		//added first centroid
		centroids.add(means.get(firstIdx).coordinate);
		
		//find the other noCentroids - 1
		for (int i = 1; i < noCentroids; ++i) {
			sum = 0.0;
			nearestIdxs = new int[means.size()];
			nearestDist = new double[means.size()];
			//find the nearest point for each value
			for (int j = 0; j < means.size(); ++j) {
				if (!means.get(j).equals(centroids.get(0))) {
					nearestDist[j] = nearest(means.get(j).coordinate);
					nearestIdxs[j] = this.nearestIdx;
					sum += nearestDist[j];
				}
			}
			
			sum = sum * rand.nextDouble();
			
			for (int j = 0; j < means.size(); ++j) {
				if ((sum -= nearestDist[j]) > 0)
					continue;
				if (centroids.contains(means.get(j)))
					continue;
				centroids.add(means.get(j).coordinate);
				break;
			}
			
		}
		
		//System.out.println("The centroids are " + centroids);
		
		return centroids;
	}
	
	
}
