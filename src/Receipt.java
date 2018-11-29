public class Receipt implements IReceipt {

    @Override
    public void PrintReceipt(IBeverage ABeverage) {
        int numExtrasOrdered = 0;
        if (!ABeverage.GetExtras().equals("")) {
            numExtrasOrdered = ABeverage.GetExtras().split(",").length;
        }

        System.out.println("=====================");
        System.out.println("Customer Name: " + ABeverage.GetCustomerName()
                + "\nBeverage: " + ABeverage.GetBeverageName()
                + "\nSize: " + ABeverage.GetSize()
                + "\nCost: $" + ABeverage.GetCost()
                + "\nCup Choice: " + ABeverage.GetCup()
                + "\nNumber of Extras added: " + numExtrasOrdered
                + "\nExtras: " + ABeverage.GetExtras());
        System.out.println("=====================");


    }
}
