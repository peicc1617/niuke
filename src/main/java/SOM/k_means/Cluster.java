package SOM.k_means;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import SOM.utils.Example;
import SOM.utils.Point3D;
import SOM.utils.Example;
import SOM.utils.Point3D;

public class Cluster {

	private Point3D centroid;
	private Point3D prevCentroid;
	
	private List<Example> members;
	private List<Example> prevMembers;
	
	public HashMap<String, Integer> classFrequence; 
	public String mostFrequent;
	
	public int counter;

	public Cluster() {
		centroid = new Point3D();
		members = new ArrayList<Example>();
		setPrevMembers(new ArrayList<Example>());
		counter = 0;
		classFrequence = new HashMap<String, Integer>();
	}

	
	public List<Example> getMembers() {
		return members;
	}

	public void setMembers(List<Example> members) {
		this.members = members;
	}

	
	public Point3D getCentroid() {
		return centroid;
	}

	public void setCentroid(Point3D centroid) {
		this.centroid = centroid;
	}


	public Point3D getPrevCentroid() {
		return prevCentroid;
	}


	public void setPrevCentroid(Point3D prevCentroid) {
		this.prevCentroid = prevCentroid;
	}


	public List<Example> getPrevMembers() {
		return prevMembers;
	}


	public void setPrevMembers(List<Example> prevMembers) {
		this.prevMembers = prevMembers;
	}
	
	public void emptyCluster() {
		this.prevMembers.clear();
		
		for (int i = 0; i < members.size(); ++i)
			prevMembers.add(members.get(i));
		
		members.clear();
	}

	public double intraClusterDistance() {
		double sum = 0.0;
		
		if (prevMembers.isEmpty())
			return 0;
		
		for (int i = 0; i < prevMembers.size(); ++i) {
			sum += prevMembers.get(i).coordinate.distance(prevCentroid);
		}
		
		sum *= 1/Math.sqrt(prevMembers.size() - 1);
		
		return sum;
	}
	
	/**
	 * Compute frequency of each class 
	 */
	public void computeFrequences() {
		String className;
		Integer freq;
		
		for (int i = 0; i < prevMembers.size(); ++i) {
			className = prevMembers.get(i).identifier;
			if (null == classFrequence.get(className)) {
				classFrequence.put(className, 0);
			} else {
				freq = classFrequence.get(className);
				freq++;
				classFrequence.put(className, freq);
			}
		}
		
		//compute the most frequent class
		mostFrequent();
	}
	
	private void mostFrequent() {
		Set<String> classNames = classFrequence.keySet();
		Iterator<String> className = classNames.iterator();
		Integer max = -1;
		String currentClass;
		
		while (className.hasNext()) {
			currentClass = className.next();
			
			if (classFrequence.get(currentClass) > max) {
				max = classFrequence.get(currentClass);
				this.mostFrequent = currentClass;
			}
		}
		
	}
	
	
}
