package phase1;
//this interface is responsible for managing specific and overall discounts
public interface DiscountAdder
{
    public String Discounting(int choice,String Amount);
    public void SetDiscount(float P,float k,float l, float m, int so);
    public String getDiscount(int choice);
}
