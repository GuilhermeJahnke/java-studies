package domain.entities.entry;

public class EntryExpenseEntities extends EntryEntities {

    private String received;
    private String receivedDate;

    public EntryExpenseEntities(String received, String receivedDate, double valor,
                                String date, String category, String description) {

        super(valor, date, category, description);

        this.received = received;
        this.receivedDate = receivedDate;

    }

    public String getReceived() {
        return received;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    @Override
    public String toString() {
        return "EntryExpenseEntities{" +
                "received=" + received +
                ", receivedDate='" + receivedDate + '\'' +
                '}';
    }
}
