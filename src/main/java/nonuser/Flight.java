package nonuser;

import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight implements Serializable {
    private static final long serialVersionUID = -1482122973020244470L;

    private final String flightId;
    private String flightName;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private String destination;
    private String airlineId;

    public Flight(String flightId, String flightName, LocalDate flightDate, LocalTime departureTime, String destination) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.airlineId = "";
    }

    public Flight(String flightId, String flightName, LocalDate flightDate,
                  LocalTime departureTime, String destination, String airlineId) {
        this(flightId, flightName, flightDate, departureTime, destination);
        this.airlineId = airlineId;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightDate=" + flightDate +
                ", departureTime=" + departureTime +
                ", destination='" + destination + '\'' +
                ", airlineId='" + airlineId + '\'' +
                '}';
    }

    public boolean updateSchedule(LocalTime newTime){
        //code

        return true;
    }

    public static boolean checkFlightIdExists(String checkFlightId){
        ArrayList<Object> flightList = new ArrayList<>();
        flightList = BinaryFileUtility.readObjects("Flight.bin");

        for (Object object : flightList) {
            if (object instanceof Flight flight) {
                if(((Flight) object).getFlightId().equals(checkFlightId)){
                    return true;
                }
            }
        }
        return false;
    }
}
