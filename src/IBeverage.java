import java.math.BigDecimal;

public interface IBeverage {

    String GetCustomerName();
    void SetCustomerName(String customerName);
    String GetBeverageName();
    void SetBeverageName(String BName);
    BigDecimal GetCost();
    void SetCost(BigDecimal bevCost);
    String GetSize();
    void SetSize(String Size);
    String GetExtras();
    void SetExtras(String Extra);
    String GetCup();
    void SetCup(String cupType);
}
