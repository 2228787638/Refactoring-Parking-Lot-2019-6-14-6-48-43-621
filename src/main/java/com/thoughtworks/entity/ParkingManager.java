package com.thoughtworks.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public ParkingManager(){
        parkingBoys=new ArrayList<>();
    }
    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void setParkingBoys(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }
}
