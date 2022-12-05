package phase1;
import java.util.Scanner;

public class UserMenu implements Menu{
    @Override
    public void FormViewer(Users q) // this is the user menu form
    {
        Startup s = new Startup();
        CheckDiscounts c = new CheckDiscounts();
        Search Search = new Search();
        Refund R;
        WalletManagement W;
        int k;
        Pay P;
        Scanner scan = new Scanner(System.in); // this part displays the functions for the user
        System.out.println
                (
                "1-Search for Service \n" +
                "2-Pay Service \n" +
                "3-Request Refund \n" +
                "4-Manage Wallet \n" +
                "5-Check discounts \n" +
                "6-Logout"
                );

        System.out.println("Enter your choice:");
        k=scan.nextInt();
        switch(k)
        {
            case 1: // user chooses searching for the service
            {
                Search.searching(q);
                FormViewer(q);
                break;
            }
            case 2: // user chooses paying for certain service
            {
                P = new Pay();
                P.PrintServices(q);
                FormViewer(q);
                break;
            }
            case 3: // user chooses to refund previous transaction
            {
                R = new Refund();
                R.RefundRequest(q);
                FormViewer(q);
                break;
            }
            case 4: // user wants to manage his wallet
            {
                W = new WalletManagement();
                W.WalletManager(q);
                FormViewer(q);
                break;
            }
            case 5: // user wants to check discounts available in the system
            {
                c.ViewDiscounts(q);
                FormViewer(q);
                break;
            }
            case 6: // user logs out
            {
                s.StartingMenu();
                break;
            }
            default:
                FormViewer(q);
        }

    }
}
