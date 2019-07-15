package com.thoughtworks.tdd;

import com.thoughtworks.entity.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoryFourTest {
    @Test
    public void should_smart_boy_park_lot_contains_more_empty_positions() {
        //given
        List<ParkingLot> parkingLotList =new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.getParkLot().put(new Ticket(),new Car());
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.getParkLot().put(new Ticket(),new Car());
        secondParkingLot.getParkLot().put(new Ticket(),new Car());
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        ParkingBoy parkingBoy =new ParkingBoy(parkingLotList);
        SmartParkingBoy cleverParkingBoy =new SmartParkingBoy(parkingLotList);
        //when
        Car car =new Car();
        Ticket ticket = cleverParkingBoy.returnTicketByCar(car);
        //then
        assertThat(true, is(cleverParkingBoy.getParkingLotList().get(0).getParkLot().containsKey(ticket)));
    }
}
