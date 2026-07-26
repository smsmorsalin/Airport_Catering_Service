package nonuser;

public class Airline {
    private final String airlineId;
    private String airlineName;
    private String contactInfo;

    public Airline(String airlineId, String airlineName, String contactInfo) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.contactInfo = contactInfo;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineId='" + airlineId + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
