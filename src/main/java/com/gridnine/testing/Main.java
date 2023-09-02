package com.gridnine.testing;

import com.gridnine.testing.interfaces.FlightFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       List<Flight> flights = FlightBuilder.createFlights();
       FlightFilter flightFilter = new FlightFilterImpl();

       flights.forEach(System.out::println);

       System.out.println("\n" + flightFilter.findByDepartureDate(flights, LocalDateTime.now()));

       System.out.println("\n" + flightFilter.findBySegmentWhereArrivalBeforeDeparture(flights));

       System.out.println("\n" + flightFilter.findByWaitingTime(flights, 2L));
    }
}