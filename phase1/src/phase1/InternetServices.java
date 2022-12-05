package phase1;
import java.util.Scanner;

public class InternetServices implements Services
{
    @Override // this function will display the internet service form for the user
    public void Execute(Users q)
    {
        IPaying P;
        Scanner scan = new Scanner(System.in);
        int WoP;
        Pay PP;
        String Amount,CreditCardNo,NoS;
        NoS = ChooseServiceProvider(q);
        System.out.println
                (
                "How would you like to pay: \n"+
                        "1-By Wallet \n" +
                        "2-By Credit Card\n" +
                        "3-Cash on delivery\n" +
                        "4-Exit"
                );
        WoP = scan.nextInt();

        switch(WoP)
        {
            case 1:
            { // this part manages the payment through wallet
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
            {  // this part manages the payment through credit card
                System.out.println("Enter Amount you want to pay:");
                scan.nextLine();
                Amount = scan.nextLine();
                P = new CreditCard();
                Amount = AddDiscount(Amount);
                System.out.println("Enter Your Credit Card Number:");
                CreditCardNo = scan.nextLine();
                P.payment(q,CreditCardNo,Amount);
                q.l.logger(NoS +" " + "Credit Card: "+q.CardNumber + " Amount: "+ Amount + " " + "L.E",Float.parseFloat(Amount));
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 3:
            { // this part manages the payment through cash on delivery
                System.out.println("Enter Amount you want to pay:");
                scan.nextLine();
                Amount = scan.nextLine();
                P = new CashOnDelivery();
                Amount = AddDiscount(Amount);
                P.payment(q,null,Amount);
                q.l.logger(NoS +" " + "Cash On Delivery" + " Amount: "+ Amount + " " + "L.E",Float.parseFloat(Amount));
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 4:
            { // this part will exit the internet services form and displays the payment form
                PP = new Pay();
                PP.PrintServices(q);
            }
            default:
                PP = new Pay();
                PP.PrintServices(q);
        }
    }

    @Override  // this part will display the service providers for the internet recharge service
    public String ChooseServiceProvider(Users q)
    {
        Scanner scan = new Scanner(System.in);
        int NosChoice;
        System.out.println
                (
                        "Internet recharge services: \n"+
                                "1-Vodafone \n" +
                                "2-Etisalat\n" +
                                "3-Orange\n" +
                                "4-We\n" +
                                "Enter your choice:"
                );
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

    public void PrintServiceProvider() // prints service providers of internet service
    {
        System.out.println
                (
                        "Internet recharge services: \n"+
                                "1-Vodafone \n" +
                                "2-Etisalat\n" +
                                "3-Orange\n" +
                                "4-We"
                );
    }
    @Override
    public String AddDiscount(String amnt) // adds discount to the internet recharge fees
    {
        DiscountAdder d = new OverAllDiscount();
        amnt =  d.Discounting(0,amnt);
        DiscountAdder dd = new SpecificDiscount();
        amnt = dd.Discounting(2,amnt);
        return amnt;
    }

}
