import java.time.LocalDate;

public abstract class Transaktion {

    private double amount;
    private String description;
    private LocalDate date;

    public Transaktion(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }
    public void getdescription(String description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public abstract double affectAmount();
    @Override
    public String toString() {
        return "Income{" + "amount=" + amount + ", description=" + description + ", date=" + date + '}';
    }

}
