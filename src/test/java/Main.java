import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Screen 1 -Welcome Screen
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String restart = null;
        boolean flag = true;
        ArrayList<Double> convertResultList = new ArrayList<Double>();

        do {

            if (flag) {
                System.out.println("Welcome to currency converter\nPlease choose an option (1/2)");
            } else {
                System.out.println("currency converter\nPlease choose an option (1/2)");
            }

            System.out.println("1.Dollars to Shekels\n2.Shekel to Dollars");
            int coinChoice = 0;

            do {
                try {
                    coinChoice = scanner.nextInt();  // Reads user input
                    if (coinChoice == 1 || coinChoice == 2)
                        break;
                    System.out.println("Invalid Choice, please try again");
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid Choice, please try again");
                    scanner.nextLine();
                }
            } while (true);

            // Screen 2 - Choice Screen
            Scanner doublescanner = new Scanner(System.in); // Create a Scanner object
            System.out.println("Please enter an amount to convert");
            double convertAmount = 0.0;

            do {
                try {
                    convertAmount = doublescanner.nextDouble(); // Reads user input
                    if (convertAmount > 0)
                        break;
                    System.out.println("Invalid Choice, please try again");
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid Choice, please try again");
                    doublescanner.nextLine();
                }
            } while (true);

            // Screen 3 - Result screen
            //CoinFactory coinFactory = new CoinFactory();
            double calculatedAmount = 0.0;
            if (coinChoice == 1) {
                Coin myUSD = CoinFactory.getCoinInstance(Coins.USD);
                calculatedAmount = myUSD.calculate(convertAmount);
            } else if (coinChoice == 2) {
                Coin myILS = CoinFactory.getCoinInstance(Coins.ILS);
                calculatedAmount = myILS.calculate(convertAmount);
            }
            System.out.println(calculatedAmount);
            convertResultList.add(calculatedAmount);

            Scanner restartScanner = new Scanner(System.in); // Create a Scanner object
            System.out.println("Start Over?\n Y / N");
            restart = restartScanner.nextLine();
            while (!(restart.equalsIgnoreCase("Y") || restart.equalsIgnoreCase("N"))) {
                try {
                    throw new Exception("Invalid Input");
                } catch (Exception exception) {
                    System.out.println("Invalid Choice, please try again");
                    restart = restartScanner.nextLine();
                }
            }

            flag = false;
        } while (restart.equalsIgnoreCase("Y"));

        System.out.println("Thanks for using our currency converter");
        System.out.println("Previous Results:" + convertResultList);
        File myObj = new File("D:\\Results.txt");
        Files.writeString(Paths.get(myObj.getPath()), "All Results:" + convertResultList);
    }
}