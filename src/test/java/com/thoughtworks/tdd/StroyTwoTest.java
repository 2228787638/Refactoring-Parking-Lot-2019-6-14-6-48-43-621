package com.thoughtworks.tdd;

import com.thoughtworks.entity.Car;
import com.thoughtworks.entity.ParkingBoy;
import com.thoughtworks.entity.ParkingLot;
import com.thoughtworks.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StroyTwoTest {
    @Test
    public void should__use_wrong_ticket_can_return_unrecognized_mesage() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        String message=Assertions.assertThrows(Exception.class,()->parkingBoy.getCarByTicket(wrongTicket)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Unrecognized parking ticket."));
    }
    @Test
    public void should__use_hava_used_ticket_can_return_unrecognized_mesage() throws Exception {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        parkingBoy.getCarByTicket(ticket);
        String message=Assertions.assertThrows(Exception.class,()->parkingBoy.getCarByTicket(ticket)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Unrecognized parking ticket."));
    }
    @Test
    public void should_have_no_ticket_fetch_car_can_return_please_provide_ticket() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        String message=Assertions.assertThrows(Exception.class,()->parkingBoy.getCarByTicket(null)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Please provide your parking ticket."));
    }

    @Test
    public void should_have_no_position_park_car_can_return_not_enough_position() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        for(int i=0;i<10;i++) {
            parkingBoy.returnTicketByCar(new Car());
        }
        String message=Assertions.assertThrows(Exception.class,()->parkingBoy.returnTicketByCar(car)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Not enough position."));
    }


}
