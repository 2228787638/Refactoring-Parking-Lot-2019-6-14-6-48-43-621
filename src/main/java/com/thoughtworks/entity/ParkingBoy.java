package com.thoughtworks.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;
    protected String message;
    public ParkingBoy() {
        parkingLotList=new ArrayList<>();
        parkingLotList.add(new ParkingLot());
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Car getCarByTicket(Ticket ticket) throws Exception {
        if(ticket==null){
            throw new Exception("Please provide your parking ticket.");
        }
        Car car=null;
        try {
            car = parkingLotList.stream().filter(d -> d.getParkLot().get(ticket) != null)
                    .map(d -> d.getParkLot().get(ticket))
                    .collect(toList()).get(0);
            parkingLotList.stream().filter(d -> d.getParkLot().get(ticket) != null).collect(toList())
            .get(0).getParkLot().remove(ticket);
        }catch(Exception e){
            throw new NoSuchElementException("Unrecognized parking ticket.");
        }
        return car;
    }
    public Ticket returnTicketByCar(Car car){
        Ticket ticket=null;
        try {
            ticket =new Ticket();
            parkingLotList.stream().filter(d -> d.getParkLot().size()<d.getLotCount())
                    .collect(toList()).get(0).getParkLot().put(ticket,car);
        }catch(Exception e){
            throw new NoSuchElementException("Not enough position.");
        }
        return ticket;
    }
    public String searchMessageByTicket(){
        return "Please provide your parking ticket.";
    }

}
