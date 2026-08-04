package nonuser;

import java.time.LocalDate;

public class Revenue {

    private LocalDate Date;
    private int orders;
    private int revenue;
    private int received;
    private int netrevenue;


    public Revenue(LocalDate date, int orders, int revenue, int received, int netrevenue) {
        Date = date;
        this.orders = orders;
        this.revenue = revenue;
        this.received = received;
        this.netrevenue = netrevenue;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getNetrevenue() {
        return netrevenue;
    }

    public void setNetrevenue(int netrevenue) {
        this.netrevenue = netrevenue;
    }
}
