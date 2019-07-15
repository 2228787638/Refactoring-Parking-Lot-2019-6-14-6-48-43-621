package com.thoughtworks.tdd;

import com.thoughtworks.entity.Car;
import com.thoughtworks.entity.ParkingBoy;
import com.thoughtworks.entity.ParkingLot;
import com.thoughtworks.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoryThreeTest {
    @Test
    public void should_park_cars_sequentially() {
        //given
        Car car =new Car();
        List<ParkingLot> parkingLotList =new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        ParkingBoy parkingBoy =new ParkingBoy(parkingLotList);
        //when
        for(int i=0;i<10;i++) {
            parkingBoy.returnTicketByCar(new Car());
        }
        Ticket ticket = parkingBoy.returnTicketByCar(car);
        //then
        assertThat(true, is(parkingBoy.getParkingLotList().get(1).getParkLot().containsKey(ticket)));
    }
}
