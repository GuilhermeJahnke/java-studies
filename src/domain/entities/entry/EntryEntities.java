package domain.entities.entry;

import java.time.LocalDateTime;

public abstract class EntryEntities  {
    private final double valor;
    private final String date;
    private final String category;
    private final String description;

    public EntryEntities( double valor, String date, String category, String description) {

        this.valor = valor;
        this.date = date;
        this.category = category;
        this.description = description;
    }


    public double getValor() {
        return valor;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "EntryEntities{" +
                "valor=" + valor +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}