package parkinglot;

import java.util.*;

public class ParkingSlot {
  static Hashtable<String, String>[] Slots = (Hashtable<String,String>[]) new Hashtable<?,?>[50];
  static int no_of_slots;
  static Set<Integer> available_slots = new HashSet<Integer>();

  
  static void createParkingLot(int n){
	  no_of_slots = n;
	  System.out.println("Parking Lot Created with "+n+" open slots");
	  for( int i = 1; i <= no_of_slots;i++){
		  available_slots.add(i);
		  Slots[i] = new Hashtable<String, String>();
	  }
  }
  
  static void status(){
	  System.out.println("Printing All Slot Status" );
	  for (int i = 1; i <= no_of_slots; i++) {		  
		  if (Slots[i].isEmpty()){ 
			  System.out.println(i+"---> Empty");
	      }
		  else{
			  System.out.println(i+"---> "+Slots[i].get("RegNo")+" "+Slots[i].get("Color"));
		  }
	  }     
  }
  
  static int findFirstFreeSlot(){
	  int emptySlotIndex = -1;
	  if (!available_slots.isEmpty()){ 
		  TreeSet<Integer> sortedSet = new TreeSet<Integer>(available_slots);
		  emptySlotIndex = (Integer)sortedSet.first();
	  }
	  return emptySlotIndex;
  }
  
  static void park(Car car){
	  int emptyslot = findFirstFreeSlot();
	  if(emptyslot == -1){
		  System.out.println("Parking Full! Sorry for the inconvinience" );
	  }
	  else{
		  Slots[emptyslot] = car.properties;
		  car.properties.put("SlotNo", ""+emptyslot);
		  System.out.println("Please park your car at slot number "+emptyslot );
		  available_slots.remove(emptyslot);
	  }
  }
  
  static void leave(int slotNo){
	  Slots[slotNo].clear();
	  available_slots.add(slotNo);
  }
  
  static void searchSlotWithColor(String color){
	  System.out.println("Slot number of all cars with color: "+color);
	  for (int i = 1; i <= no_of_slots; i++) {
		  if (!Slots[i].isEmpty()){ 
	        	if(Slots[i].get("Color").equals(color)){
	        		System.out.println(i);
	        	}
	      }
	  }
  }
  
  static void searchWithRegNo(String regNo){
	  System.out.println("Slot numbers of all cars with Registration No: "+regNo);
	  for (int i = 1; i < no_of_slots; i++) {
		  if (!Slots[i].isEmpty()){ 
	        	if(Slots[i].get("RegNo").equals(regNo)){
	        		System.out.println(i);
	        	}
	      }
	  }
  }
  
  static void searchRegNoWithColor(String color){
	  System.out.println("Regitration numbers of all cars with color: "+color);
	  for (int i = 1; i <= no_of_slots; i++) {
		  if (!Slots[i].isEmpty()){ 
	        	if(Slots[i].get("Color").equals(color)){
	        		System.out.println(Slots[i].get("RegNo"));
	        	}
	      }
	  }
  }
}
