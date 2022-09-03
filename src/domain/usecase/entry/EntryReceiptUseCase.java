package domain.usecase.entry;

import data.repository.entrys.EntryReceiptRepository;
import domain.entities.entry.EntryReceiptEntities;
import shared.Utils;

import java.util.ArrayList;

public class EntryReceiptUseCase {
    private final EntryReceiptRepository repository;

    EntryReceiptUseCase() {
        repository = new EntryReceiptRepository();
    }

    private void verifyAllIsEmpty(Boolean received, String receivedDate, Double valor, String date,
                                  String category, String description) {

        if (Utils.isEmptyParams(received.toString())) {
            throw new IllegalArgumentException("O [received] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(receivedDate)) {
            throw new IllegalArgumentException("O [receivedDate] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(valor.toString())) {
            throw new IllegalArgumentException("O [valor] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(date)) {
            throw new IllegalArgumentException("O [date] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(category)) {
            throw new IllegalArgumentException("O [category] não pode ser vazio, digite corretamente");
        }
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }
    }

    public EntryReceiptEntities create(boolean received, String receiptDate, double valor, String date,
                                       String category, String description) {

        verifyAllIsEmpty(received, receiptDate, valor, date, category, description);

        return repository.createEntryReceipt(received, receiptDate, valor, date, category, description);
    }

    public EntryReceiptEntities edit(boolean received, String receiptDate, String description, double valor, String date,
                                     String category) {

        verifyAllIsEmpty(received, receiptDate, valor, date, category, description);

        return repository.editEntryReceipt(received, receiptDate, description, valor, date, category);
    }

    public void remove(String description) {
        if (Utils.isEmptyParams(description)) {
            throw new IllegalArgumentException("O [description] não pode ser vazio, digite corretamente");
        }
        
        repository.removeEntryReceipt(description);
    }

    public ArrayList<EntryReceiptEntities> getAll() {
        return repository.getAll();
    }

}
