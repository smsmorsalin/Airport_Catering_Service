package nonuser;

import utility.databaseAccessor;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CateringOrder implements Serializable {
    private final int orderId;
    private final String FlightId; //FF
    private final String airlineId;
    private final int airlineRepresentativeId;
    private final LocalDate orderDate;
    private final String deliveryLocation;
    private ArrayList<String> orderItemIds; //FF of orderItem
    private LocalDate deliveryDate;
    private LocalTime deliveryTime;
    private String Status;
    private boolean isDelay;
    private String orderAcceptOrRejectBy;

    public CateringOrder(String flightId, String airlineId, int airlineRepresentativeId, LocalDate orderDate, String deliveryLocation, ArrayList<String> orderItemIds, LocalDate deliveryDate, LocalTime deliveryTime) {
        this.orderId = generateOrderId();
        FlightId = flightId;
        this.orderDate = orderDate;
        this.airlineRepresentativeId = airlineRepresentativeId;
        this.deliveryLocation = deliveryLocation;
        this.orderItemIds = orderItemIds;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        Status = "Pending";
        this.isDelay = false;
        this.airlineId = airlineId;
        this.orderAcceptOrRejectBy = "N/A";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getFlightId() {
        return FlightId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public ArrayList<String> getOrderItemIds() {
        return orderItemIds;
    }

    public void setOrderItemIds(ArrayList<String> orderItemIds) {
        this.orderItemIds = orderItemIds;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getAirlineRepresentativeId() {
        return airlineRepresentativeId;
    }

    public boolean isDelay() {
        return isDelay;
    }

    public void setDelay(boolean delay) {
        isDelay = delay;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public String getOrderAcceptOrRejectBy() {
        return orderAcceptOrRejectBy;
    }

    public void setOrderAcceptOrRejectBy(String orderAcceptOrRejectBy) {
        this.orderAcceptOrRejectBy = orderAcceptOrRejectBy;
    }

    private static int generateOrderId() {
        return databaseAccessor.generateNewUniqueId("CateringOrder.bin", "orderId");
    }

    public static CateringOrder findById(int orderId) {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream("CateringOrder.bin"))) {

            while (true) {

                Object object = ois.readObject();

                if (object instanceof CateringOrder cateringOrder) {

                    if (cateringOrder.getOrderId() == orderId) {
                        return cateringOrder;
                    }
                }
            }

        } catch (EOFException e) {
            // End of file reached normally
            System.out.println("Catering order not found: " + orderId);

        } catch (FileNotFoundException e) {
            System.out.println("CateringOrder.bin file not found");

        } catch (InvalidClassException e) {
            System.out.println("CateringOrder class version does not match the file");

        } catch (IOException e) {
            System.out.println("Error reading CateringOrder.bin");

        } catch (ClassNotFoundException e) {
            System.out.println("CateringOrder class not found");
        }

        return null;
    }

    @Override
    public String toString() {
        return "CateringOrder{" +
                "orderId=" + orderId +
                ", FlightId='" + FlightId + '\'' +
                ", airlineId='" + airlineId + '\'' +
                ", airlineRepresentativeId=" + airlineRepresentativeId +
                ", orderDate=" + orderDate +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", orderItemIds=" + orderItemIds +
                ", deliveryDate=" + deliveryDate +
                ", deliveryTime=" + deliveryTime +
                ", Status='" + Status + '\'' +
                ", isDelay=" + isDelay + '\'' +
                ", orderAcceptOrRejectBy='" + orderAcceptOrRejectBy + '\'' +
                '}';
    }
}
