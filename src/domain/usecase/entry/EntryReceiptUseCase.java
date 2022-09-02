package domain.usecase.entry;

import data.repository.entrys.EntryReceiptRepository;
import domain.entities.entry.EntryReceiptEntities;

import java.util.ArrayList;

public class EntryReceiptUseCase {
    private final EntryReceiptRepository repository;

    EntryReceiptUseCase() {
        repository = new EntryReceiptRepository();
    }

    public EntryReceiptEntities create(boolean received, String receivedDate, double valor, String date,
                                       String category, String description) {

        return repository.createEntryReceipt(received, receivedDate, valor,
                date, category, description);
    }

    public EntryReceiptEntities edit(boolean received, String receiptDate, String description, double valor, String date,
                                     String category) {

        return repository.editEntryReceipt(received, receiptDate, description, valor, date, category);
    }

    public void remove(String description) {
        repository.removeEntryReceipt(description);
    }

    public ArrayList<EntryReceiptEntities> getAll() {
        return repository.getAll();
    }

}
