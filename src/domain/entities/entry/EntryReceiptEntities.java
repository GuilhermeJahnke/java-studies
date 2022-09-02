package domain.entities.entry;

public class EntryReceiptEntities extends EntryEntities {
    private boolean received;
    private String receivedDate;

    public EntryReceiptEntities(boolean received, String receivedDate, double valor, String date, String category,
                                String description) {

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
        return "EntryReceiptEntities{" +
                "received=" + received +
                ", receivedDate='" + receivedDate + '\'' +
                '}';
    }
}
