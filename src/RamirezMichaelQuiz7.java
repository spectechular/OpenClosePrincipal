import java.math.BigDecimal;
import java.util.Scanner;

//Michael Ramirez
// OCP Decorator Quiz 7

public class RamirezMichaelQuiz7 {



    private static String GetCustomerName() {

        try {


            String stringInput;

            System.out.println("Enter Customer Name: ");
            Scanner scannerInput = new Scanner(System.in);
            stringInput = scannerInput.nextLine();
            if ("".equals(stringInput)) {
                stringInput = "Customer";
            }

            return stringInput;
        } catch (Exception e) {
            System.out.println("Error getting customer name");
            return null;
        }
    }

    public static void main(String[] args) {
        boolean closeRegister = false;
        BigDecimal registerTotal = new BigDecimal("0.0");


        do {

            boolean orderCancelled = false;
            do {

                String customerName = GetCustomerName();

                //Add more drinks to this string when adding to menu options
                IMenu beverageMenu = new Menu("Espresso%Decaf%Mocha");
                beverageMenu.DisplayMenu();
                String beverageChoice = beverageMenu.GetChoice();

                if (beverageChoice.equals("cancel")) {
                    System.out.println("Order cancelled");
                    orderCancelled = true;
                    break;
                }

                //Add more sizes here when adding to menu options
                IMenu beverageSizeMenu = new Menu("Small%Medium%Large%All-Nighter");
                beverageSizeMenu.DisplayMenu();
                String beverageSize = beverageSizeMenu.GetChoice();

                if (beverageSize.equals("cancel")) {
                    System.out.println("Order cancelled");
                    orderCancelled = true;
                    break;
                }

                IBeverage currentDrink = null;

                //Add more drinks here when adding to menu options. Should match what is added to first menu interface string
                if ("Espresso".equals(beverageChoice)) {
                    currentDrink = new Espresso(customerName, beverageSize);
                } else if ("Decaf".equals(beverageChoice)) {
                    currentDrink = new Decaf(customerName, beverageSize);
                } else if ("Mocha".equals(beverageChoice)) {
                    currentDrink = new Mocha(customerName, beverageSize);
                }


                //Add more extras to this string when adding to menu options
                boolean extrasAddCancelled = false;
                do {

                    IMenu decoratorMenu = new Menu("Pumpkin Spice%Whip%Soy");
                    decoratorMenu.DisplayMenu();
                    String decoratorChoice = decoratorMenu.GetChoice();

                    //Add more extras here when adding to menu options. Should match what is added itemDecorator menu interface string
                    if ("Pumpkin Spice".equals(decoratorChoice)) {
                        currentDrink = new PumpkinSpice(currentDrink);
                    } else if ("Whip".equals(decoratorChoice)) {
                        currentDrink = new Whip(currentDrink);
                    } else if ("Soy".equals(decoratorChoice)) {
                        currentDrink = new Soy(currentDrink);
                    } else if ("cancel".equals(decoratorChoice)) {
                        System.out.println("No extra selected. Continuing\n\n");
                        extrasAddCancelled = true;
                    }

                } while (extrasAddCancelled == false);

                IMenu cupMenu = new Menu("Regular Cup%Holiday Cup");
                cupMenu.DisplayMenu();
                String cupChoice = cupMenu.GetChoice();

                if ("cancel".equals(cupChoice)){
                    System.out.println("Order Cancelled");
                    break;
                }
                else if ("Regular Cup".equals(cupChoice)){
                    currentDrink = new RegularCup(currentDrink);
                }
                else if ("Holiday Cup".equals(cupChoice)){
                    currentDrink = new HolidayCup(currentDrink);
                }

                System.out.println("Here is the receipt:");
                IReceipt myReceipt = new Receipt();
                myReceipt.PrintReceipt(currentDrink);
                registerTotal = registerTotal.add(currentDrink.GetCost());

                System.out.println("\nNEXT IN LINE!\n\n");


            } while (true);

            System.out.println("Would you like to put in the order for another customer? 1 for next customer. 0 to close register");

            String closeRegisterInput;
            int closeRegisterChoice = 1;
            do {
                try {
                    Scanner scannerInput = new Scanner(System.in);
                    closeRegisterInput = scannerInput.nextLine();
                    closeRegisterChoice = Integer.parseInt(closeRegisterInput);
                } catch (NumberFormatException numFormatE) {
                    System.out.println("Please enter valid input 0 or 1");
                }
            } while (closeRegisterChoice < 0 || closeRegisterChoice > 1);

            if (closeRegisterChoice == 0) {
                closeRegister = true;
            } else {
                closeRegister = false;
                System.out.println("NEXT!\n\n");
            }

        } while (closeRegister == false);

        System.out.println("Closing Register...");
        System.out.println("Total for day is: $" + registerTotal);

    }

}

