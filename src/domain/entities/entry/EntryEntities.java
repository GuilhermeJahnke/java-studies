package domain.entities.entry;

public class EntryEntities {
    private double valor;
    private String date;
    private String category;
    private String description;

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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
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