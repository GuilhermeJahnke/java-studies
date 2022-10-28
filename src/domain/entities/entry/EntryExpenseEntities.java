package domain.entities.entry;

public class EntryExpenseEntities extends EntryEntities {

    private boolean received;
    private String receivedDate;

    public EntryExpenseEntities(boolean received, String receivedDate, double valor,
                                String date, String category, String description) {

        super(valor, date, category, description);

        this.received = received;
        this.receivedDate = receivedDate;

    }

    public boolean getReceived() {
        return received;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceived(boolean received) {
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
