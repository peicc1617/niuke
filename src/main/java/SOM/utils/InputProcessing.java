package SOM.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputProcessing {

	private String inputFilename;
	private ArrayList<Point3D> coordinates;
	
	public InputProcessing(String inputFilename) {
		this.inputFilename = inputFilename;
		coordinates = new ArrayList<Point3D>();
	}
	
	public ArrayList<Example> processFile() {
		ArrayList<Example> exampleSet = new ArrayList<Example>();
		ArrayList<String> example;
		Point3D point;
		Example learningEx;
		FileInputStream inputStream;
		String line;
		String tmp[];
		
		try {
			//open file
			inputStream = new FileInputStream(inputFilename);
			DataInputStream in = new DataInputStream(inputStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//process the input
			while ((line = br.readLine()) != null) {
				example = new ArrayList<String>();
				tmp = line.split(",");
				point = new Point3D();
				
				for (int i = 0; i < tmp.length; ++i) {
					example.add(tmp[i]);
					switch (i){
					case 4:
						point.setX(Double.valueOf(tmp[i]));
						break;
					case 5:
						point.setY(Double.valueOf(tmp[i]));
						break;
					case 6:
						point.setZ(Double.valueOf(tmp[i]));
						break;
					}
						
					
				}
				
				learningEx = new Example(example);
				coordinates.add(point);
				exampleSet.add(learningEx);
			}
			
			br.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return exampleSet;
	}
	
	
	public void printInput(ArrayList<ArrayList<String>> input) {
		for (int i = 0; i < input.size(); ++i) {
			System.out.println(input.get(i));
		}
	}

	public ArrayList<Point3D> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Point3D> coordinates) {
		this.coordinates = coordinates;
	}
	
}
