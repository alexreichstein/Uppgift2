import java.time.LocalDate;

public class Income extends Transaktion{

    public Income(double amount, String description,LocalDate date) {

        super(amount,description,date);

    }

    @Override
    public double affectAmount() {
        return getAmount();
    }

    public double showIncome(){
        return affectAmount();
    }

}
