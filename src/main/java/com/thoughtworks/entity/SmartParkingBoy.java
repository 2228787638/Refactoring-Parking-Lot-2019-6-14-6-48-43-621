package com.thoughtworks.entity;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toList;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket returnTicketByCar(Car car){
        ParkingLot maxParkingLot=null;
        for(ParkingLot parkingLot:parkingLotList) {
            if(maxParkingLot==null) {
                maxParkingLot = parkingLot;
            }
            if(parkingLot.getParkLot().size() < parkingLot.getLotCount()&&parkingLot.getParkLot().size() <= maxParkingLot.getParkLot().size()){
                maxParkingLot = parkingLot;
            }
        }
        Ticket ticket=null;
        try {
            ticket =new Ticket();
            ParkingLot finalMaxParkingLot = maxParkingLot;
            parkingLotList.stream().filter(d -> d== finalMaxParkingLot)
                    .collect(toList()).get(0).getParkLot().put(ticket,car);
        }catch(Exception e){
            throw new NoSuchElementException("Not enough position.");
        }
        return ticket;
    }
}
