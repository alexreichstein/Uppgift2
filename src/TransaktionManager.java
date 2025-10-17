import java.util.ArrayList;
import java.util.List;

public class TransaktionManager {

    private List<Transaktion> transaktions;

    public TransaktionManager() {
        transaktions = new ArrayList<>();
    }

    public void addTransaktion(Transaktion transaktion) {
        transaktions.add(transaktion);
    }

    public void removeTransaktion(Transaktion transaktion) {
        transaktions.remove(transaktion);
    }

    public double calculateAmount() {
        double amount = 0;
        for (Transaktion transaktion : transaktions) {
            amount += transaktion.getAmount();
        }
        return amount;
    }

    public void showAllTransaktions() {
        for (Transaktion transaktion : transaktions) {
            System.out.println(transaktion);
        }
    }
    public List<Transaktion> getTransaktions() {
        return transaktions;
    }

    public double calculateTotalExpenses(){
        double expenses = 0;
        for (Transaktion transaktion : transaktions) {
            if (transaktion instanceof Expense){
                expenses += transaktion.getAmount();
            }
        }
        return expenses;
    }

    public double calculateTotalIncome(){
        double income = 0;
        for (Transaktion transaktion : transaktions) {
            if (transaktion instanceof Income){
                income += transaktion.getAmount();
            }
        }
        return income;
    }

}
