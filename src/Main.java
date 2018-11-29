import java.util.Scanner;

public class Main {


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
        }catch (Exception e){
            System.out.println("Error getting customer name");
        }
    }

    public static void main(String[] args) {
        boolean closeRegister = false;
        do {

            String customerName = GetCustomerName();


        } while (closeRegister == false);


    }
}

