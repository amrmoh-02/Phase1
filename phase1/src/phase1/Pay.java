package phase1;
import java.util.Scanner;

public class Pay
{  // this part of the code prints the services for the user in the pay form to choose service
    public void PrintServices(Users q)
    {
        Menu m = new UserMenu();
        Services i;
        Scanner scan = new Scanner(System.in);
        int k;
        System.out.println
                (
                "1-Mobile Recharge Services\n" +
                "2-Internet Payment Services\n" +
                "3-Landline Services\n" +
                "4-Donations\n" +
                "5-Exit"
                );
        System.out.println("Enter your choice:");
        k=scan.nextInt();
        switch(k)  // according to the user's choice, the chosen service will be called
        {
            case 1: // mobile service is chosen and paid
            {
                i= new MobileServices();
                i.Execute(q);
                PrintServices(q);
                break;
            }
            case 2: //  internet service is chosen and paid
            {
                i = new InternetServices();
                i.Execute(q);
                PrintServices(q);
                break;
            }
            case 3: // landline service is chosen and paid
            {
                i = new LandlineServices();
                i.Execute(q);
                PrintServices(q);
                break;
            }
            case 4: // donations are chosen and paid
            {
                i = new DonationServices();
                i.Execute(q);
                PrintServices(q);
                break;
            }
            case 5: // the user is driven back to the user menu
            {
                m.FormViewer(q);
                break;
            }
            default:

        }
    }
}
