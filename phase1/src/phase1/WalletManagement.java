package phase1;
import java.util.Scanner;

public class WalletManagement
{
    //this function will manage the wallet from the users perspective
    public void WalletManager(Users q)
    {
        String cnum;
        Scanner scan = new Scanner(System.in);
        int choice2,cash;
        System.out.println("what do you want to do to your wallet?");
        System.out.println(
                "1- Add funds to wallet\n" +
                "2- Print current Balance");
        choice2 = scan.nextInt();
        if(choice2 == 1)
        {
            //this choice will add the amount of money needed from the credit card
            scan.nextLine();
            System.out.println("Enter credit card number");
            cnum = scan.nextLine();
            System.out.println("Enter the Amount you want to add:");
            cash = scan.nextInt();
            q.wallet.add(cash);
        }
        else if (choice2 == 2)
        {
            //this will display the current money inside the wallet
            System.out.println(q.wallet.PrintMoney());
        }
    }


}
