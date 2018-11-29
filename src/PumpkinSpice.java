import java.math.BigDecimal;

public class PumpkinSpice implements IExtrasDecorator {
    private IBeverage aBeverage;
    private String customerName = "";
    private String beverageName = "";
    private BigDecimal cost = new BigDecimal("0.0");
    private String extras = "Pumpkin Spice";
    private String size = "";
    private String cupType = "";

    public PumpkinSpice(IBeverage aBev) {
        this.aBeverage = aBev;
        this.size = aBev.GetSize();

        if (null != size) {
            switch (size) {
                case "Small":
                    cost = new BigDecimal(".39");
                    break;
                case "Medium":
                    cost = new BigDecimal(".59");
                    break;
                case "Large":
                    cost = new BigDecimal(".79");
                    break;
                case "All-Nighter":
                    cost = new BigDecimal(".99");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String GetCustomerName() {

        try {
            return aBeverage.GetCustomerName();
        } catch (Exception e) {
            System.out.println("Error with Get Customer Name");
            return null;
        }
    }

    @Override
    public void SetCustomerName(String customerName) {
        try {
            aBeverage.SetCustomerName(customerName);
        } catch (Exception e) {
            System.out.println("Error Set Customer Name");
        }
    }

    @Override
    public String GetBeverageName() {
        try {
            return aBeverage.GetBeverageName();
        } catch (Exception e) {
            System.out.println("Error in Get Beverage Name");
            return null;
        }
    }

    @Override
    public void SetBeverageName(String BName) {
        try {
            aBeverage.SetBeverageName(BName);
        } catch (Exception e) {
            System.out.println("Error in Set Beverage Name");
        }
    }

    @Override
    public BigDecimal GetCost() {
        try {
            return aBeverage.GetCost().add(cost);
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

            //Handles if no extras have been added yet to comma is not put after blank space
            if (aBeverage.GetExtras().equals("")){
                return extras;
            }else {
                return aBeverage.GetExtras() + ", " + extras;
            }
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
