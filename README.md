# Flight filter — test assignment

A Java test assignment: filter a list of flights (each flight is a list of segments with departure
and arrival times) by three rules.

| Method | Returns flights where… |
|---|---|
| `findFlightWithDepartureBeforeDate(flights, date)` | any segment departs before `date` (e.g. now — departure in the past) |
| `findBySegmentWhereArrivalBeforeDeparture(flights)` | any segment arrives before it departs (invalid data) |
| `findByWaitingTime(flights, hours)` | the total time on the ground between segments exceeds `hours` |

- `FlightFilter` — the interface, `FlightFilterImpl` — stream-based implementation.
- `testClasses/` — the model (`Flight`, `Segment`) and `FlightBuilder` with sample flights.
- `FlightFilterImplTest` — JUnit 5 tests for each rule.

## Run

Java 11+, no build tool:

```bash
javac -d out $(find src/main -name '*.java')
java -cp out com.gridnine.testing.Main
```

The tests need JUnit 5 on the classpath (in IntelliJ IDEA: add the `junit-jupiter` library to the
module and run `FlightFilterImplTest`).
