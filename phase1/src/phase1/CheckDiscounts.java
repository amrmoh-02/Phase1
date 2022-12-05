package phase1;
import java.util.Scanner;

public class CheckDiscounts
{  // this part is responsible for viewing discounts for different services for the user
    public void ViewDiscounts(Users q)
    {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the service you want to see the Discounts for: \n" +
                "1- Mobile Recharge Services\n" +
                "2- Internet Payment Services\n" +
                "3- Landline Services\n" +
                "4- Donations.");
        choice = scan.nextInt();
        DiscountAdder oi = new SpecificDiscount();
        System.out.println(oi.getDiscount(choice));

    }
}
