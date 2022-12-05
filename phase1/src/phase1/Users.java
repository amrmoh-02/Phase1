package phase1;
public class Users
{  // this part initiates user account and wallet
    public String Username,Email,Password;
    public Wallet wallet = new Wallet();
    Logs l = new Logs();
    String CardNumber;

    public Users() // this part is the constructor giving initial value to its attributes
    {

        Username ="ljkshadflkjhasfdglkjhasdfg";
        Email = "ljkshadflkjhasfdglkjhasdfg";
        Password = "ljkshadflkjhasfdglkjhasdfg";
    }

    public void setUser(String u,String e,String p)
    { // setter for user attributes
        Username = u;
        Email = e;
        Password = p;
    }

    public void setCardNumber(String cardNumber)
    {
        CardNumber = cardNumber;
    } // setter for cardNumber
}
