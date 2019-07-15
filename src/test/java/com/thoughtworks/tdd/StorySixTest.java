package com.thoughtworks.tdd;

import com.thoughtworks.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StorySixTest {
    @Test
    public void should_can_fetch_car_with_specify_parkingboy_by_manager() throws Exception {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy =new ParkingBoy();
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        Ticket ticket=parkingManager.getParkingBoys().get(0).returnTicketByCar(car);
        Car reCar = parkingManager.getParkingBoys().get(0).getCarByTicket(ticket);
        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_can_park_and_fetch_car_by_manager() throws Exception {
        //given
        ParkingManager parkingManager = new ParkingManager();
        Car car = new Car();
        //when
        Ticket ticket=parkingManager.returnTicketByCar(car);
        Car reCar = parkingManager.getCarByTicket(ticket);
        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_return_message_can_use_wrong_ticket_by_manager_tells_boy() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        Ticket ticket=parkingManager.getParkingBoys().get(0).returnTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        String message= Assertions.assertThrows(Exception.class,()->parkingManager.getParkingBoys().get(0).getCarByTicket(wrongTicket)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Unrecognized parking ticket."));

    }
    @Test
    public void should_use_hava_used_ticket_can_return_unrecognized_mesage_by_manager_tells_boy() throws Exception {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        Car reFirstCar=parkingManager.getParkingBoys().get(0).getCarByTicket(ticket);
        String message= Assertions.assertThrows(Exception.class,()->parkingManager.getParkingBoys().get(0).getCarByTicket(ticket)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Unrecognized parking ticket."));
    }
    @Test
    public void should_have_no_ticket_can_return_please_provide_ticket_by_manager_tells_boy() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        String message= Assertions.assertThrows(Exception.class,()->parkingManager.getParkingBoys().get(0).getCarByTicket(null)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Please provide your parking ticket."));
    }
    @Test
    public void should_have_no_position_can_return_not_enough_position_by_manager_tells_boy() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        for(int i=0;i<10;i++) {
            parkingManager.getParkingBoys().get(0).returnTicketByCar(new Car());
        }
        String message= Assertions.assertThrows(Exception.class,()->parkingManager.getParkingBoys().get(0).returnTicketByCar(car)).getMessage();
        //then
        Assertions.assertTrue(message.contains("Not enough position."));

    }
}
