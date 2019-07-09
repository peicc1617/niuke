package SOM.som;

import SOM.utils.AlgorithmUtils;
import SOM.utils.Constants;
import SOM.utils.Point3D;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
public class SOM {
	public static Point3D weights[][];
	public static Point2D position;
	public static double uMatrix[][];

	/**
	 * Initialize the weight matrix, with three-dimensional value representing
	 * the position of the indicator
	 */
	private static void initialWeights() {
		Random rand = new Random();
		weights = new Point3D[Constants.NEURON_NO][Constants.NEURON_NO];

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				weights[i][j] = new Point3D(rand);
			}
	}

	/**
	 * Finds the closest neuron to a value from the example set
	 * 
	 * @param examplePt
	 *            point from the example set
	 * @return the closest point
	 */
	private static Point3D closestValue(Point3D examplePt) {
		Point3D closest = null;
		position = new Point(-1, -1);
		double distance, minDistance = Double.MAX_VALUE;

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				// compute the distance (as a value)
				distance = examplePt.distance(weights[i][j]);

				if (distance < minDistance) {
					minDistance = distance;
					closest = weights[i][j];
					position.setLocation(i, j);
				}
			}

		return closest;
	}

	/**
	 * Find the points which are in the neighbourhood of the point which is
	 * closest to the given example
	 * 
	 * @param reference
	 *            the reference point
	 * @param radius
	 *            maximum distance from reference point
	 * @return list of points from the neighbourhood
	 */
	private static List<Point3D> neighbourhood(Point3D reference, double radius) {
		List<Point3D> neighPts = new ArrayList<Point3D>();
		double distance;

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				distance = position.distance(i, j);
				//distance = reference.distance(weights[i][j]);
				//System.out.println("Distance is " + distance);
				if (!(reference.equals(weights[i][j])) && distance <= radius)
					neighPts.add(weights[i][j]);
			}
		return neighPts;
	}

	/**
	 * Update the weights of all the neurons from neighbourhood
	 * 
	 * @param neighbours
	 *            the neighbors
	 * @param example
	 *            value of the input example
	 * @param learningRate
	 *            learningRate value
	 */
	private static void updateWeights(List<Point3D> neighbours,
			Point3D example, double learningRate) {
		Point3D tmp, sub;

		for (int i = 0; i < neighbours.size(); ++i) {
			tmp = neighbours.get(i);

			// subtract from the example the weight of the neuron
			sub = example.subsract(tmp);

			// multiply the value with the learning rate
			sub.scalarMultiply(learningRate);

			// add with the old weight of the neuron
			tmp.add(sub);
		}
	}

	private static void uMatrixElem(int line, int column) {
		uMatrix[line][column] = 0.0;

		// up
		if (line - 1 >= 0) {
			uMatrix[line][column] = weights[line][column]
					.distance(weights[line - 1][column]);
		}

		// down
		if (line + 1 < Constants.NEURON_NO) {
			uMatrix[line][column] = weights[line][column]
					.distance(weights[line + 1][column]);
		}

		// left
		if (column - 1 >= 0) {
			uMatrix[line][column] = weights[line][column]
					.distance(weights[line][column - 1]);
		}

		// right
		if (column + 1 < Constants.NEURON_NO) {
			uMatrix[line][column] = weights[line][column]
					.distance(weights[line][column + 1]);
		}
	}

	public static void buildUmatrix() {
		uMatrix = new double[Constants.NEURON_NO][Constants.NEURON_NO];

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j)
				uMatrixElem(i, j);
	}

	/**
	 * Contains all the activities of a epoque
	 * 
	 * @param pointExample
	 *            point from the learning example
	 * @param learning_rate
	 *            learning_rate at this step
	 * @param radius
	 *            at this point
	 */
	private static void epoque(Point3D pointExample, double learning_rate,
			double radius) {
		// find the closest point to the training value
		Point3D closestPt = closestValue(pointExample);

		// find neighbors of closest point
		List<Point3D> neighbors = neighbourhood(closestPt, radius);

		// update weights of neighbors
		updateWeights(neighbors, pointExample, learning_rate);
	}

	public static void selfOrganizingMaps(ArrayList<Point3D> trainingPts) {
		double learning_rate;
		double radius;

		// initialize the weights matrix
		initialWeights();

		for (int i = 1; i <= Constants.MAX_ITER; ++i) {
			learning_rate = AlgorithmUtils.learningRate(i);
			radius = AlgorithmUtils.radius(i);

			for (int j = 0; j < trainingPts.size(); ++j)
				epoque(trainingPts.get(j), learning_rate, radius);
		}
	}

	public static void displayWeights() {
		for (int i = 0; i < Constants.NEURON_NO; ++i) {
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				System.out.println(weights[i][j]);
			}
		}
	}

	public static void displayUmatrix() {
		System.out.println("--------- U matrix --------------");
		for (int i = 0; i < Constants.NEURON_NO; ++i) {
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				System.out.print(uMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static List<Point3D> getWeigthsList() {
		List<Point3D> weightList = new ArrayList<Point3D>();

		for (int i = 0; i < Constants.NEURON_NO; ++i)
			for (int j = 0; j < Constants.NEURON_NO; ++j) {
				weightList.add(weights[i][j]);
			}

		return weightList;
	}

	/**
	 * Find a cluster from umatrix
	 * 
	 * @param startPosition
	 *            value from which the lookup starts
	 * @return
	 */
	private static Point2D getClusterFromUmatrix(Point2D startPosition) {
		List<Point3D> cluster = new ArrayList<Point3D>();
		Queue<Point2D> points = new LinkedList<Point2D>();
		Point2D element, tmp;
		int line, column, lineNext, columnNext;

		points.add(startPosition);

		while (!points.isEmpty()) {
			// extract element from queue
			element = points.remove();
			
			line = lineNext = (int) (element.getX());
			column = columnNext = (int) (element.getY());
			
			if (uMatrix[line][column] == -1)
				continue;

			// add neighbors which meet the conditions in the queue
			// up
			if (line - 1 >= 0) {
				lineNext--;
				if (uMatrix[line][column] < uMatrix[lineNext][columnNext]
						&& uMatrix[lineNext][columnNext] != -1.0) {
					tmp = new Point(lineNext, columnNext);
					points.add(tmp);
				}
			}

			lineNext = line;

			// down
			if (line + 1 < Constants.NEURON_NO) {
				lineNext++;
				if (uMatrix[line][column] < uMatrix[lineNext][columnNext]
						&& uMatrix[lineNext][columnNext] != -1.0) {
					tmp = new Point(lineNext, columnNext);
					points.add(tmp);
				}
			}
			lineNext = line;

			// left
			if (column - 1 >= 0) {
				columnNext--;
				if (uMatrix[line][column] < uMatrix[lineNext][columnNext]
						&& uMatrix[lineNext][columnNext] != -1.0) {
					tmp = new Point(lineNext, columnNext);
					points.add(tmp);
				}
			}
			columnNext = column;

			// right
			if (column + 1 < Constants.NEURON_NO) {
				columnNext++;
				if (uMatrix[line][column] < uMatrix[lineNext][columnNext]
						&& uMatrix[lineNext][columnNext] != -1.0) {
					tmp = new Point(lineNext, columnNext);
					points.add(tmp);
				}
			}
			columnNext = column;

			
			// mark the current node as visited
			uMatrix[line][column] = -1.0;

			// add the node to the cluster
			cluster.add(weights[line][column]);
		}

		if (cluster.size() <= 1)
			return null;
		return startPosition;
	}

	/**
	 * Obtain all centres of clusters from U-matrix
	 * 
	 * @return the list of resulted centroids
	 */
	public static List<Point3D> getAllClusters() {
		List<Point3D> clusterCentres = new ArrayList<Point3D>();
		Point2D startPoint, newStartPoint;

		while (true) {
			// find the startPoint
			startPoint = AlgorithmUtils.matrixMin(uMatrix);

			// verify if there are any clusters available
			if (startPoint.getX() == -1 || startPoint.getY() == -1)
				break;

			// find the cluster
			newStartPoint = getClusterFromUmatrix(startPoint);
			if (newStartPoint != null)
				clusterCentres.add(weights[(int)(newStartPoint.getX())][(int)(newStartPoint.getY())]);
		}

		return clusterCentres;
	}

}
