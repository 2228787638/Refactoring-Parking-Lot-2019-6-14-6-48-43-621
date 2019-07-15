package com.thoughtworks.tdd;

import com.thoughtworks.entity.Car;
import com.thoughtworks.entity.ParkingBoy;
import com.thoughtworks.entity.ParkingLot;
import com.thoughtworks.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StoryOneTest {
    @Test
    public void should_get_car_use_ticket_by_car() throws Exception {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        Car reCar=parkingBoy.getCarByTicket(ticket);

        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_get_multiple_car_use_ticket_by_multiple_car() throws Exception {
        //given
        Car firstCar =new Car();
        Car secondCar =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket firstTicket=parkingBoy.returnTicketByCar(firstCar);
        Ticket secondTicket=parkingBoy.returnTicketByCar(secondCar);
        Car reFirstCar=parkingBoy.getCarByTicket(firstTicket);
        Car reSecondCar=parkingBoy.getCarByTicket(secondTicket);

        //then
        assertThat(reFirstCar, is(firstCar));
        assertThat(reSecondCar, is(secondCar));
    }
    @Test
    public void should__use_wrong_ticket_fetch_car() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        //then
        Assertions.assertThrows(Exception.class,()->parkingBoy.getCarByTicket(wrongTicket));

    }
    @Test
    public void should__use_have_used_ticket_can_not_fetch_car() throws Exception {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingBoy.returnTicketByCar(car);
        Car reFirstCar=parkingBoy.getCarByTicket(ticket);
        //then
        Assertions.assertThrows(Exception.class,()->parkingBoy.getCarByTicket(ticket));

    }
    @Test
    public void should_can_not_park_car_if_more_than_ten_car() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        for(int i=0;i<10;i++) {
            Ticket ticket = parkingBoy.returnTicketByCar(new Car());
        }
        //then
        Assertions.assertThrows(Exception.class,()->parkingBoy.returnTicketByCar(car));
    }
}
