package domain.entities.finance_goal;

public class FinanceGoalEntities {
    private String name;
    private String description;
    private double value;
    private String date;
    private boolean achieved;

    public FinanceGoalEntities(String name, String description, double value, String date, boolean achieved) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.date = date;
        this.achieved = achieved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    @Override
    public String toString() {
        return "FinanceGoal{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", date='" + date + '\'' +
                ", achieved=" + achieved +
                '}';
    }
}
