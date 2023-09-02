import com.gridnine.testing.FlightFilterImpl;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterImplTest {

    public static List<Flight> flights;
    public static FlightFilterImpl flightFilter;

    @BeforeAll
    public static void beforeAll() {
        flights = FlightBuilder.createFlights();
        flightFilter = new FlightFilterImpl();
    }

    @Test
    public void shouldFindOneFlightWhenDepartureDateIsNow() {
        List<Flight> departureFlights = flightFilter.findFlightWithDepartureBeforeDate(flights, LocalDateTime.now());
        assertEquals(1, departureFlights.size());
    }

    @Test
    public void shouldFindOneFlightWhereArrivalBeforeDeparture() {
        List<Flight> departureFlights = flightFilter.findBySegmentWhereArrivalBeforeDeparture(flights);
        assertEquals(1, departureFlights.size());
    }

    @Test
    public void shouldFindTwoFlightsWhenWaitingTimeOneHour() {
        List<Flight> departureFlights = flightFilter.findByWaitingTime(flights, 1L);
        assertEquals(2, departureFlights.size());
    }

    @Test
    public void shouldFindTwoFlightsWhenWaitingTimeTwoHour() {
        List<Flight> departureFlights = flightFilter.findByWaitingTime(flights, 2L);
        assertEquals(2, departureFlights.size());
    }
}
