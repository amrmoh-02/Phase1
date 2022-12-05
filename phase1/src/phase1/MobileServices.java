package phase1;
import java.util.Scanner;
public class MobileServices implements Services
{
    @Override
    public void Execute(Users q) // this part executes the way fo payment of mobile recharge service
    {
        IPaying P;
        Scanner scan = new Scanner(System.in);
        int WoP;
        Pay PP;
        String Amount,CreditCardNo,NoS;
        NoS = ChooseServiceProvider(q);
        System.out.println(
                "How would you like to pay: \n"+
                        "1-By Wallet \n" +
                        "2-By Credit Card\n" +
                        "3-Cash on delivery\n" +
                        "4- Exit");
        WoP = scan.nextInt();

        switch(WoP)
        {
            case 1:
            { // this part is the payment form for the user choosing wallet payment
                System.out.println("Enter Amount you want to pay:");
                scan.nextLine();
                Amount = scan.nextLine();
                P = new WalletPayment();
                Amount = AddDiscount(Amount);
                if(P.payment(q,null,Amount))
                {
                    q.l.logger(NoS +" " + "Wallet Payment" + " Amount: "+ Amount + " " + "L.E",Float.parseFloat(Amount));
                    System.out.println("Transaction Completed Successfully");
                }
                else
                {
                    System.out.println("insufficient funds");
                    Execute(q);
                }
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 2:
            {  // this part manages payment form for the credit card option
                System.out.println("Enter Amount you want to pay:");
                scan.nextLine();
                Amount = scan.nextLine();
                P = new CreditCard();
                Amount = AddDiscount(Amount);
                System.out.println("Enter Your Credit Card Number:");
                CreditCardNo = scan.nextLine();
                P.payment(q,CreditCardNo,Amount);
                q.l.logger(NoS +" " + "Credit Card: "+q.CardNumber + " Amount: "+ Amount + " " + "L.E",Integer.parseInt(Amount));
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 3:
            {  // this part manages payment form for the cash on delivery option
                System.out.println("Enter Amount you want to pay:");
                scan.nextLine();
                Amount = scan.nextLine();
                P = new CashOnDelivery();
                Amount = AddDiscount(Amount);
                P.payment(q,null,Amount);
                q.l.logger(NoS +" " + "Cash On Delivery" + " Amount: "+ Amount + " " + "L.E",Integer.parseInt(Amount));
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 4: //this part prints the services for the user
            {
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            default: // default case prints services for the user too
                PP = new Pay();
                PP.PrintServices(q);
        }
    }


    @Override
    public String ChooseServiceProvider(Users q) // this part manages mobile recharge service providers
    {
        Scanner scan = new Scanner(System.in);

        int NosChoice;
        System.out.println
                (
                "Mobile recharge services: \n"+
                "1-Vodafone \n" +
                "2-Etisalat\n" +
                "3-Orange\n" +
                "4-We"
                );
        System.out.println("Enter your choice:"); //returns the name of service providers
        NosChoice = scan.nextInt();
        if (NosChoice == 1)
        {
            return "Vodafone";
        }
        else if (NosChoice == 2)
        {
            return "Etisalat";
        }
        else if (NosChoice == 3)
        {
            return "Orange";
        }
        else if (NosChoice == 4)
        {
            return "WE";
        }
        return null;
    }

    public void PrintServiceProvider() // prints service providers for the user
    {
        System.out.println
                (
                "Mobile recharge services: \n"+
                        "1-Vodafone \n" +
                        "2-Etisalat\n" +
                        "3-Orange\n" +
                        "4-We"
                );
    }
    @Override
    public String AddDiscount(String amnt) // applies discount for the mobile recharge service
    {
        DiscountAdder d = new OverAllDiscount();
        amnt =  d.Discounting(0,amnt);
        SpecificDiscount dd = new SpecificDiscount();
        amnt = dd.Discounting(1,amnt);
        return amnt;
    }
}
