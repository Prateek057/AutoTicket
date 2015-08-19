package parkinglot;

import java.util.Hashtable;

public class Car {
	Hashtable<String, String> properties = new Hashtable<String, String>();
	Car(String regNo, String color){
		properties.put("RegNo", regNo);
		properties.put("Color", color);
	}
}
