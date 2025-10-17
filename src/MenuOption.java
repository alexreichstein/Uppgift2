public class MenuOption {

    private int number;
    private String decscription;

    public MenuOption(int number, String decscription) {
        this.number = number;
        this.decscription = decscription;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + ". " + decscription;
    }
}
