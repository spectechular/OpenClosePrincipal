import java.math.BigDecimal;

public class Decaf implements IBeverage {


    private String customerName = "";
    private String beverageName = "";
    private BigDecimal cost = new BigDecimal("0.0");
    private String extras = "";
    private String size = "";
    private String cupType = "";

    public Decaf(String customerName, String size) {
        this.customerName = customerName;
        this.size = size;
        this.beverageName = "Decaf";

        if (size != null) {
            switch (size) {
                case "Small":
                    cost = new BigDecimal("1.99");
                    break;
                case "Medium":
                    cost = new BigDecimal("2.99");
                    break;
                case "Large":
                    cost = new BigDecimal("3.99");
                    break;
                case "All-Nighter":
                    cost = new BigDecimal("4.99");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String GetCustomerName() {

        try {
            return customerName;
        } catch (Exception e) {
            System.out.println("Error with Get Customer Name");
            return null;
        }
    }

    @Override
    public void SetCustomerName(String customerName) {
        try {
            this.customerName = customerName;
        } catch (Exception e) {
            System.out.println("Error Set Customer Name");
        }
    }

    @Override
    public String GetBeverageName() {
        try {
            return beverageName;
        } catch (Exception e) {
            System.out.println("Error in Get Beverage Name");
            return null;
        }
    }

    @Override
    public void SetBeverageName(String BName) {
        try {
            this.beverageName = BName;
        } catch (Exception e) {
            System.out.println("Error in Set Beverage Name");
        }
    }

    @Override
    public BigDecimal GetCost() {
        try {
            return cost;
        } catch (Exception e) {
            System.out.println("Error in Get Cost");
            return null;
        }
    }

    @Override
    public void SetCost(BigDecimal bevCost) {
        try {
            this.cost = bevCost;
        } catch (Exception e) {
            System.out.println("Error in Set Beverage Cost");
        }
    }

    @Override
    public String GetSize() {
        try {
            return size;
        } catch (Exception e) {
            System.out.println("Error in Get Size");
            return null;
        }
    }

    @Override
    public void SetSize(String Size) {
        try {
            this.size = Size;
        } catch (Exception e) {
            System.out.println("Error in Set Size");
        }
    }

    @Override
    public String GetExtras() {
        try {
            return extras;
        } catch (Exception e) {
            System.out.println("Error in Get Extras");
            return null;
        }
    }

    @Override
    public void SetExtras(String Extra) {
        try {
            this.extras = Extra;
        } catch (Exception e) {
            System.out.println("Error in Set Extras");
        }
    }

    @Override
    public String GetCup() {
        try {
            return cupType;
        }catch (Exception e){
            System.out.println("Error Get Cup");
            return null;
        }
    }

    @Override
    public void SetCup(String cupType) {
        try {
            this.cupType = cupType;
        }catch (Exception e){
            System.out.println("Error in Set Cup Type");
        }
    }

}
