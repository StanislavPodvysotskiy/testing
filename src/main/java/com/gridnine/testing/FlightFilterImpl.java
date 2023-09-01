package com.gridnine.testing;

import com.gridnine.testing.interfaces.FlightFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {

    public FlightFilterImpl() {
    }

    @Override
    public List<Flight> findByDepartureDate(List<Flight> flights, LocalDateTime date) {
        return flights.stream().filter(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(date))).collect(Collectors.toList());
    }

    @Override
    public List<Flight> findBySegmentWhereArrivalBeforeDeparture(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate()
                        .isBefore(segment.getDepartureDate()))).collect(Collectors.toList());
    }

    @Override
    public List<Flight> findByWaitingTime(List<Flight> flights, Long waitingTime) {
        return flights.stream().filter(flight -> {
            long waitingSeconds = waitingTime * 60 * 60;
            List<Segment> segments = flight.getSegments();
            if (segments.size() == 1) {
                if (Duration.between(segments.get(0).getArrivalDate(), segments.get(0).getDepartureDate())
                        .getSeconds() > waitingSeconds) {
                    return true;
                }
            }
            for (int i =0; i + 1 < segments.size(); i++) {
                if (Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate())
                        .getSeconds() > waitingSeconds) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }
}
