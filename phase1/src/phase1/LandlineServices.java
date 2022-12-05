package phase1;
import java.util.Scanner;

public class LandlineServices implements Services
{
    int choice;
    float receipt =100; // this part executes the landline services options
    public void Execute(Users q)
    {
        Pay P = new Pay();
        PrintServiceProvider();
        ChooseServiceProvider(q);
        if(choice == 3)
        {
            P.PrintServices(q);
        }
    }

    public void PrintServiceProvider() // this displays the options of paying the landline fees
    {
        System.out.println("Landline Services: \n" +
                "1-Monthly receipt \n" +
                "2-Quarterly receipt\n" +
                "3-Exit \n" +
                "Choice: ");
    }

    public String ChooseServiceProvider(Users q) // this menu manages the payment form for landline services
    {
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        receipt = Float.parseFloat(AddDiscount(Float.toString(receipt)));
        if (choice == 1)
        {
            System.out.println("For User: "+q.Username +" Your monthly payment = "+ receipt + " L.E");
        }
        else if (choice == 2)
        {
            System.out.println("For User: "+q.Username +" Your quarterly payment = "+ receipt*3 + " L.E");
        }
        return null;
    }
    public String AddDiscount(String k) // this part adds discounts to the landline fees
    {
        DiscountAdder D = new OverAllDiscount();
        receipt = Float.parseFloat(D.Discounting(0,Float.toString(receipt)));
        DiscountAdder DD = new SpecificDiscount();
        receipt = Float.parseFloat(DD.Discounting(3,Float.toString(receipt)));
        return Float.toString(receipt);
    }
}
