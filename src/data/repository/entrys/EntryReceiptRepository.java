package data.repository.entrys;

import domain.entities.entry.EntryReceiptEntities;

import java.util.ArrayList;

public class EntryReceiptRepository {
    private final ArrayList<EntryReceiptEntities> mockDataBase = new ArrayList<>();

    public EntryReceiptEntities findByDescription(String description) {
        for (EntryReceiptEntities entryReceiptEntities : mockDataBase) {
            if (entryReceiptEntities.getDescription().equals(description)) return entryReceiptEntities;
        }

        throw new IllegalArgumentException("Nenhum lançamento de receita encontrado com esta descrição");
    }


    public EntryReceiptEntities createEntryReceipt(boolean received, String receivedDate, double valor,
                                                   String date, String category, String description) {

        EntryReceiptEntities newEntryReceipt = new EntryReceiptEntities(received, receivedDate, valor, date,
                category, description);

        mockDataBase.add(newEntryReceipt);

        return newEntryReceipt;
    }

    public EntryReceiptEntities editEntryReceipt(boolean received, String receivedDate, String description,
                                                 double valor, String date, String category) {

        EntryReceiptEntities receiptEdit = findByDescription(description);

        receiptEdit.setValor(valor);
        receiptEdit.setDate(date);
        receiptEdit.setCategory(category);
        receiptEdit.setDescription(description);
        receiptEdit.setReceived(received);
        receiptEdit.setReceivedDate(receivedDate);

        return receiptEdit;
    }

    public void removeEntryReceipt(String description) {
        mockDataBase.remove(findByDescription(description));
    }

    public ArrayList<EntryReceiptEntities> getAll() {
        return mockDataBase;
    }
}
