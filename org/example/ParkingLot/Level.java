package org.example.ParkingLot;

import org.example.ParkingLot.VehicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<parkingspot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);
        for (int i = 1; i < numSpots; i++) {
            parkingSpots.add(new parkingspot(i));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (parkingspot spot : parkingSpots) {
            if (spot.isavailable() && spot.getVehicletype() == vehicle.getType()) {
                spot.parkvehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle) {
        for (parkingspot spot : parkingSpots) {
            if (!spot.isavailable() && spot.getParkvehicle().equals(vehicle)) {
                spot.unpark(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (parkingspot spot : parkingSpots) {
            System.out.println("Spot " + spot.getspotnum() + ": " + (spot.isavailable() ? "Available" : "Occupied"));
        }
    }
}