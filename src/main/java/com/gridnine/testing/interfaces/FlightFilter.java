package com.gridnine.testing.interfaces;

import com.gridnine.testing.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {

    List<Flight> findByDepartureDate(List<Flight> flights, LocalDateTime date);

    List<Flight> findBySegmentWhereArrivalBeforeDeparture(List<Flight> flights);

    List<Flight> findByWaitingTime(List<Flight> flights, Long waitingTime);
}
