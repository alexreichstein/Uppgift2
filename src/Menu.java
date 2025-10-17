import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuOption> options;

    public Menu() {

        options = new ArrayList<>();
        options.add(new MenuOption(1, "Lägga in transaktioner"));
        options.add(new MenuOption(2, "Radera transaktioner"));
        options.add(new MenuOption(3, "Se nuvarande balans"));
        options.add(new MenuOption(4, "Se spenderade årsvis, månadsvis, veckovis och dagvis"));
        options.add(new MenuOption(5, "Se inkomst årsvis, månadsvis, veckovis och dagvis"));
        options.add(new MenuOption(6, "Avsluta"));
        options.add(new MenuOption(7, "Rensa tidigare sparad data"));
    }

    public void printMenu(){
        for (MenuOption option : options){
            System.out.println(option);
        }
    }

    public MenuOption getOptionByNumber(int number){
        for (MenuOption option : options){
            if (option.getNumber() == number){
                return option;
            }
        }
        return null;
    }
}
