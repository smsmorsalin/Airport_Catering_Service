package nonuser;

public class FinancialReport {

    private int revenue;
    private int cost;
    private final boolean paymentReceive;
    private int profit;
    private String report;

    public FinancialReport(boolean paymentReceive, int revenue, int cost, int profit, String report) {
        this.paymentReceive = paymentReceive;
        this.revenue = revenue;
        this.cost = cost;
        this.profit = profit;
        this.report = report;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isPaymentReceive() {
        return paymentReceive;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
