package com.thoughtworks.entity;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

public class SuperSmartParkingBoy extends  ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket returnTicketByCar(Car car){
        ParkingLot parkLot=null;
        for(ParkingLot parkingLot:parkingLotList) {
            if(parkLot==null) {
                parkLot = parkingLot;
            }
            if(parkingLot.getParkLot().size()/parkingLot.getLotCount() <= parkLot.getParkLot().size()/parkLot.getLotCount()){
                parkLot=parkingLot;
            }
        }
        Ticket ticket=null;
        try {
            ticket =new Ticket();
            ParkingLot finalParkLot = parkLot;
            parkingLotList.stream().filter(d -> d== finalParkLot)
                    .collect(toList()).get(0).getParkLot().put(ticket,car);
        }catch(Exception e){
            throw new NoSuchElementException("Not enough position.");
        }
        return ticket;
    }
}
