package parkinglot;

import org.testng.annotations.Test;

public class parkinglot_test {
	static Car[] parkingcar = (Car[]) new Car[50];
	@Test(priority=1)
	public void testCreate(){
		ParkingSlot.createParkingLot(6);
		parkingcar[0] = new Car("1111", "Red");
		parkingcar[1] = new Car("1122", "Blue");
		parkingcar[2] = new Car("1133", "Black");
		parkingcar[3] = new Car("1144", "Black");
		parkingcar[4] = new Car("1166", "Blue");
		parkingcar[5] = new Car("1177", "Gold");
		parkingcar[6] = new Car("2211", "Black");
		ParkingSlot.park(parkingcar[0]);
		ParkingSlot.park(parkingcar[1]);
		ParkingSlot.park(parkingcar[2]);
		ParkingSlot.park(parkingcar[3]);
		ParkingSlot.park(parkingcar[4]);
		ParkingSlot.park(parkingcar[5]);
		ParkingSlot.park(parkingcar[6]);
		ParkingSlot.leave(1);
		ParkingSlot.park(parkingcar[6]);
		ParkingSlot.status();
		ParkingSlot.searchRegNoWithColor("Gold");
		ParkingSlot.searchSlotWithColor("Black");
		ParkingSlot.searchWithRegNo("1122");
	}
	
}
