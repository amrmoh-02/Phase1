package phase1;
import java.util.Scanner;
//this is the service form for the Donation Form
public class DonationServices implements Services
{
    public void Execute(Users q)
    {
        float donation;
        int WoP;
        IPaying p;
        String NoS,CreditCardNo;
        Pay PP;
        Scanner scan = new Scanner(System.in);
        NoS = ChooseServiceProvider(q);
        System.out.println(
                "How would you like to pay: \n"+
                        "1-By Wallet \n" +
                        "2-By Credit Card\n" +
                        "3-Cash on delivery\n" +
                        "4-Exit");
        System.out.println("Enter the way you want to pay: ");
        WoP = scan.nextInt();
        System.out.println("Enter the amount you want to pay: ");
        donation = scan.nextInt();
        scan.nextLine();
        //this will prompt the user to choose the way of payment
        switch (WoP)
        {
            case 1:
            {
                p = new WalletPayment();
                //this will calculate the overall and the specific discounts
                donation = Float.parseFloat(AddDiscount(Float.toString(donation)));
                if (p.payment(q,null,Float.toString(donation)))
                {
                    //this will log the user's transaction in the log form
                    q.l.logger(" Donation to"  + NoS + " Amount: "+ donation + " " + "L.E",donation);
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
                // this part prompts the credit card form for the user
            {
                p = new CreditCard();
                donation = Float.parseFloat(AddDiscount(Float.toString(donation)));
                System.out.println("Enter Your Credit Card Number:");
                CreditCardNo = scan.nextLine();
                p.payment(q,CreditCardNo,Float.toString(donation));
                //this will log the user's transaction in the log form
                q.l.logger("Donation To "+NoS+ "Credit Card: "+ q.CardNumber + " Amount: "+ donation + " " + "L.E",donation);
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 3: // this part part prompts the cash on delivery receipt for the user
            {
                p = new CashOnDelivery();
                donation = Integer.parseInt(AddDiscount(Float.toString(donation)));
                p.payment(q,null,Float.toString(donation));
                //this will log the user's transaction in the log form
                q.l.logger("Donation to " +NoS+ " Amount: "+ donation + " " + "L.E",donation);
                System.out.println("Transaction Completed Successfully");
                PP = new Pay();
                PP.PrintServices(q);
                break;
            }
            case 4: //this part prints the services for the user
            {
                PP = new Pay();
                PP.PrintServices(q);
            }
            default:
        }
    }

    public void PrintServiceProvider()  //prints the servicec' providers for the userr
    {
        System.out.println("Donation Services: \n" +
                "1- Cancer Hospitals \n" +
                "2- Schools \n " +
                "3- NGOs (Non-Profitable Organization\n");
    }

    public String ChooseServiceProvider(Users q) // prompts donation form for the user
    {
        Scanner scan = new Scanner(System.in);
        int NosChoice;
        System.out.println(
                 "Donation Services: \n" +
                 "1-Cancer Hospitals \n" +
                 "2-Schools \n" +
                 "3-NGOs (Non-Profitable Organization\n" +
                 "Enter your Choice: "
                );
        NosChoice = scan.nextInt();
        if (NosChoice == 1)
        {
            return "Cancer Hospitals";
        }
        else if (NosChoice == 2)
        {
            return "Schools";
        }
        else if (NosChoice == 3)
        {
            return "NGOs (Non-Profitable Organization";
        }
        return null;
    }

    public String AddDiscount(String amt) //This will apply the discounts on the receipt
    {
        DiscountAdder D = new OverAllDiscount();
        amt = D.Discounting(0,amt);
        DiscountAdder DD = new SpecificDiscount();
        amt = DD.Discounting(4,amt);
        return amt;
    }
}
