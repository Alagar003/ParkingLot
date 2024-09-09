package org.example.ParkingLot;
import org.example.ParkingLot.VehicleType.CAR;
import org.example.ParkingLot.VehicleType.TRUCK;
import org.example.ParkingLot.VehicleType.BUS;
import org.example.ParkingLot.VehicleType.Vehicle;

public class Main {

    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 8));


        Vehicle car = new CAR("TN678");
        Vehicle truck = new TRUCK("PY012");
        Vehicle BUS = new BUS("TN8996");


        boolean carParked = parkingLot.parkVehicle(car);
        System.out.println("Car parked: " + carParked);

        boolean truckParked = parkingLot.parkVehicle(truck);
        System.out.println("Truck parked: " + truckParked);

        boolean BUSParked = parkingLot.parkVehicle(BUS);
        System.out.println("Bus parked: " + BUSParked);


        parkingLot.displayAvailability();


        boolean carUnparked = parkingLot.unpark(car);
        System.out.println("Car unparked: " + carUnparked);

        boolean truckUnparked = parkingLot.unpark(truck);
        System.out.println("Truck unparked: " + truckUnparked);

        boolean BUSUnparked = parkingLot.unpark(BUS);
        System.out.println("Bus unparked: " + BUSUnparked);

        parkingLot.displayAvailability();
    }

    public static void main(String[] args) {
        run();
    }
}
