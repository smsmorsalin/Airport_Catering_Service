package nonuser;

import utility.BinaryFileUtility;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight implements Serializable {

    private final String flightId;
    private String flightName;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private String destination;

    public Flight(String flightId, String flightName, LocalDate flightDate, LocalTime departureTime, String destination) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.destination = destination;
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
