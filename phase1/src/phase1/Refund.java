package phase1;
import java.util.Scanner;

public class Refund
{
    public void RefundRequest(Users u) // this part reviews the refund requests of the user
    {
        RefundReply r = new RefundReply();
        Scanner scan = new Scanner(System.in);
        int choice;
        String q =" ";
        for (int i = 0 ; i<u.l.LogCounter; i++)
        {
            if(u.l.refunded[i])
            {
                q ="requested";
            }
            System.out.println(i + "-" + u.l.log[i] +" "+ q);
            q = " ";
        }
        System.out.println("Enter the Transaction number you want to refund");
        choice = scan.nextInt();
        if (u.l.refunded[choice])
        {
            System.out.println("request already denied");
        }
        else
        {
            r.TakeRefunds(u,u.l.log[choice],choice);
            u.l.refunded[choice] = true;
            System.out.println("Refund request sent");
        }
    }
}

