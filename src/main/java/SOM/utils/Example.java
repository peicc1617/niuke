package SOM.utils;

import java.util.ArrayList;

public class Example {
	public String instanceName;
	public String identifier;
	public String timestamp;
	public String date;
	public Point3D coordinate;
	public String activity;
	
	public Example(){
		
	}
	
	public Example(ArrayList<String> entry) {
		instanceName = entry.get(0);
		identifier = entry.get(1);
		timestamp = entry.get(2);
		date = entry.get(3);
		
		coordinate = new Point3D();
		coordinate.setX(Double.valueOf(entry.get(4)));
		coordinate.setY(Double.valueOf(entry.get(5)));
		coordinate.setZ(Double.valueOf(entry.get(6)));
		
		activity = entry.get(7);
	}
}
