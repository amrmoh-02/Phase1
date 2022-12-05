package phase1;
import java.util.Scanner;
public class RefundReply
{  // this part responsible for accessing transactions in the users' logs
    static  String [] Request =  new String [100];
    static int [] index = new int[100];
    static public Users [] Requestee = new Users[100];
    static int refundCounter = 0;


    public void TakeRefunds(Users u,String l,int k) // this part manages refund requests
    {
        Request [refundCounter] = l;
        Requestee [refundCounter] = u;
        index[refundCounter] = k;
        refundCounter++;
    }

    public void RequestResponse(Users u) // this part is accessed by the admin to accept or deny the refund requests
    {

        if(refundCounter==0)
        {
            System.out.println("No requests");
        }
        int choice;
        for (int i = 0; i < refundCounter; i++)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println(Requestee[i].Username + " " +Request[i]);
            System.out.println("Enter 1 to accept refund or 2 to deny refund");
            choice = scan.nextInt();
            if (choice == 1)
            {
                Requestee[i].wallet.add(Requestee[i].l.amount[index[i]]);
                System.out.println(Requestee[i].Username  + "has been refunded " + Requestee[i].l.amount[index[i]]);
            }
            else if (choice == 2)
            {
                System.out.println("Refund Denied");
            }
        }
        refundCounter = 0;
    }
}
