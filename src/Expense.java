import java.time.LocalDate;

public class Expense extends Transaktion {

    public Expense(double amount, String description, LocalDate date) {
        super(amount,description,date);
    }
    @Override
    public double affectAmount() {
        return -getAmount();
    }

}
