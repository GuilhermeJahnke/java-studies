package domain.entities.entry;

public class EntryInvestmentEntities extends EntryEntities {
    private boolean rescued;
    private String dueDate;
    private Double amountIncome;

    public EntryInvestmentEntities(boolean rescued, String dueDate, Double amountIncome, double valor, String date,
                                   String category, String description) {

        super(valor, date, category, description);

        this.rescued = rescued;
        this.dueDate = dueDate;
        this.amountIncome = amountIncome;
    }

    public boolean getRescued() {
        return rescued;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Double getAmountIncome() {
        return amountIncome;
    }

    public void setRescued(boolean rescued) {
        this.rescued = rescued;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setAmountIncome(Double amountIncome) {
        this.amountIncome = amountIncome;
    }

    @Override
    public String toString() {
        return "EntryInvestmentEntities{" +
                "rescued=" + rescued +
                ", dueDate='" + dueDate + '\'' +
                ", amountIncome=" + amountIncome +
                '}';
    }
}

