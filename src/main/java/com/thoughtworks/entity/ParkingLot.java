package com.thoughtworks.entity;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket,Car> parkLot;
    private int lotCount=10;

    public HashMap<Ticket, Car> getParkLot() {
        return parkLot;
    }

    public int getLotCount() {
        return lotCount;
    }

    public void setLotCount(int lotCount) {
        this.lotCount = lotCount;
    }

    public ParkingLot(int lotCount) {
        this.lotCount = lotCount;
    }

    public void setParkLot(HashMap<Ticket, Car> parkLot) {
        this.parkLot = parkLot;
    }

    public ParkingLot() {
        parkLot =new HashMap<>();
    }


}
