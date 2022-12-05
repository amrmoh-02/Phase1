package phase1;
public class CreditCard implements IPaying{
    //this is the option for credit card way of payment
    @Override
    public boolean payment(Users l, String CardNo, String AmountToPay)
    {
        l.setCardNumber(CardNo);
        return true;
    }
}
