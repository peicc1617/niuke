package SOM.utils;

import java.util.Random;

public class Point3D {
	private double x;
	private double y;
	private double z;
	
	public Point3D(){
		setX(0.0);
		setY(0.0);
		setZ(0.0);
	}
	
	public Point3D(Random rand) {
		setX(rand.nextDouble());
		setY(rand.nextDouble());
		setZ(rand.nextDouble());
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Compute the distance between 2 3D points
	 * @param arg the other point
	 * @return value of the distance
	 */
	public double distance(Point3D arg) {
		return 	Math.pow(this.x - arg.x, 2) + 
				Math.pow(this.y - arg.y, 2) +
				Math.pow(this.z - this.z, 2);
	}
	
	/**
	 * Subtract two 3D points
	 * @param arg the value to be subtracted
	 * @return the result
	 */
	public Point3D subsract(Point3D arg) {
		Point3D pt = new Point3D();
		pt.x = this.x - arg.x;
		pt.y = this.y - arg.y;
		pt.z = this.z - arg.z;
		
		return pt;
	}
	
	/**
	 * Multiply a 3D point with a scalar 
	 * @param scalar
	 */
	public void scalarMultiply(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		this.z *= scalar;
	}
	
	/**
	 * Compute the sum of two 3D points
	 * @param arg the 3D point to be added
	 */
	public void add(Point3D arg) {
		this.x += arg.x;
		this.y += arg.y;
		this.z += arg.z;
	}
	
	/**
	 * Divide each coordinate of the point with a given value
	 * @param value the value to divide with
	 */
	public void divideWithScalar(double value) {
		this.x /= value;
		this.y /= value;
		this.z /= value;
	}
	
	public Point3D clone( ) {
		Point3D tmpPt = new Point3D();
		
		tmpPt.x = this.x;
		tmpPt.y = this.y;
		tmpPt.z = this.z;
		
		return tmpPt;
	}

	@Override
	public String toString(){
		return "[x] " + x + " [y] " + y + " [z] " + z;
	}
	
	@Override
	public boolean equals(Object obj){
		Point3D point;
		
		if (this == obj)
			return true;
		
		point = (Point3D)obj;
		
		if (this.x == point.x && this.y == point.y && this.z == point.z)
			return true;
		
		return false;
	}
}