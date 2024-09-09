package org.example.ParkingLot;
import org.example.ParkingLot.VehicleType.Vehicle;
import org.example.ParkingLot.VehicleType.VehicleType;


public class parkingspot{
    private final int spotnum;
    private VehicleType VehicleType = null;
    private Vehicle parkvehicle;

    public parkingspot(int spotNum) {
        this.spotnum = spotNum;
        this.VehicleType = VehicleType.CAR;
    }


    public synchronized boolean isavailable(){
        return parkvehicle == null;
    }

    public synchronized void parkvehicle(Vehicle vehicle){
        if(isavailable() && vehicle.getType() == VehicleType){
            parkvehicle = vehicle;
        }else {
            throw new IllegalArgumentException("Not Parked");
        }
    }

    public synchronized void unpark(Vehicle vehicle){
        parkvehicle = null;
    }

    public VehicleType getVehicletype(){
        return VehicleType;
    }

    public  Vehicle getParkvehicle(){
        return parkvehicle;
    }

    public int getspotnum(){
        
        return spotnum;
    }

}
