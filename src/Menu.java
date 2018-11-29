import java.util.Scanner;

public class Menu implements IMenu {

    private String[] arrayMenuItems;
    private int numMenuItems;
    private String menuItemsString;


    @Override
    public void DisplayMenu() {
        try {
            arrayMenuItems = menuItemsString.split("%");
            numMenuItems = arrayMenuItems.length;
            int itemsCounter = 1;
            System.out.println("\t\tMenu\nItems on the menu are: ");
            for (String stringMenuItem : arrayMenuItems) {

                System.out.println(itemsCounter);
                System.out.println(".");
                System.out.println(stringMenuItem);
                itemsCounter++;
            }
        } catch (Exception e) {
            System.out.println("Error displaying menu");
        }
    }

    @Override
    public String GetChoice() {
        try {
            String stringInput;
            int choice = 0;
            Scanner scannerInput = new Scanner(System.in);

            do {
                try {
                    System.out.println("\nEnter choice between 1 and " + numMenuItems + " or 0 to cancel: ");
                    stringInput = scannerInput.nextLine();
                    choice = Integer.parseInt(stringInput);
                } catch (NumberFormatException numFormatE) {
                    System.out.println("Please enter valid input as single number");
                }
            } while (choice < 1 || choice > numMenuItems);
            return (arrayMenuItems[choice - 1]);
        } catch (Exception e) {
            System.out.println("Error getting customer item choice");
            return null;
        }
    }

    public Menu(String menuItemsString) {
        this.menuItemsString = menuItemsString;
    }
}
