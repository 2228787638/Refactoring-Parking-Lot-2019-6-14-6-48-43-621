package com.thoughtworks.tdd;

import com.thoughtworks.entity.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoryFiveTest {
    @Test
    public void should_super_smart_boy_park_with_larger_available_position_rate() {
        //given
        List<ParkingLot> parkingLotList =new ArrayList<>();
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setLotCount(5);
        //firstParkingLot停入一辆车
        firstParkingLot.getParkLot().put(new Ticket(),new Car());
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.setLotCount(20);
        //secondParkingLot停入两辆车
        secondParkingLot.getParkLot().put(new Ticket(),new Car());
        secondParkingLot.getParkLot().put(new Ticket(),new Car());
        parkingLotList.add(firstParkingLot);
        parkingLotList.add(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy =new SuperSmartParkingBoy(parkingLotList);
        //when
        Car car =new Car();
        Ticket ticket = superSmartParkingBoy.returnTicketByCar(car);
        //then
        assertThat(true, is(superSmartParkingBoy.getParkingLotList().get(1).getParkLot().containsKey(ticket)));
    }
}
