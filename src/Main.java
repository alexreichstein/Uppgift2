import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        TransaktionManager transaktionManager = new TransaktionManager();

        boolean running = true;

        while (running) {
            System.out.println("=====Meny=====");
            menu.printMenu();
            System.out.print("Val: ");

            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Otillåtet val! Du måste skriva in en siffra");
                scanner.nextLine();
                continue;
            }

            MenuOption selected = menu.getOptionByNumber(choice);

            if (selected == null) {
                System.out.println("Du måste skriva in en siffra mellan 1-7");
                continue;
            }

            switch (selected.getNumber()){
                case 1 -> {
                System.out.println("\n--- Lägga till transaktion ---");
                System.out.println("Är det en 1 - Inkomst eller 2 - Utgift?");
                int choice1 = scanner.nextInt();
                scanner.nextLine();

                    System.out.print("Ange belopp: ");
                    double amount =  scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ange vad du inkomsten/utgiften kommer ifrån: ");
                    String description =  scanner.nextLine();

                    Transaktion transaktion;
                    if (choice1 == 1) {
                        transaktion = new Income(amount, description, LocalDate.now());
                    } else{
                        transaktion = new Expense(amount, description, LocalDate.now());
                    }

                    transaktionManager.addTransaktion(transaktion);
                    System.out.println("Registrerat!");
                }

                case 2 -> {
                    System.out.println("\n--- Radera transaktion ---");
                transaktionManager.showAllTransaktions();


                if (transaktionManager.getTransaktions().isEmpty()) {
                    System.out.println("Inga registrerade transaktioner ännu");
                    break;

                }
                System.out.print("Ange index att ta bort, börja från 0: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < transaktionManager.getTransaktions().size()) {
                    Transaktion remove = transaktionManager.getTransaktions().get(index);
                    transaktionManager.removeTransaktion(remove);
                    System.out.println("Transaktion borttagen!");
                } else {
                    System.out.println("Ogiltigt index");
                }
            }
                case 3 -> {
                    System.out.println("\n--- Nuvarande balans ---");
                    double balance = transaktionManager.calculateAmount();
                    System.out.println("Balans: " + balance);
                }


                case 4 -> System.out.println("Visa spenderade pengar");
                case 5 -> System.out.println("Visar inkomster");
                case 6 -> System.out.println("Rensar tidigare sparad data");
                case 7 -> {
                    System.out.println("Avslutar");
                    running = false;
                }
                default -> System.out.println("Välj mellan 1 - 7");
                }
            }

        }

    }

