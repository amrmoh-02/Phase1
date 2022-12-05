package phase1;
import java.util.Scanner;
public class AdminMenu implements Menu
{
    //this is the Admin form
    @Override
    public void FormViewer(Users q)
    {
        // variable initiation
        int p,k,ss,pp,qq;
        DiscountAdder sp;
        DiscountAdder ov;
        RefundReply r;
        Startup s;

        // admin menu 
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "1- Set Discount \n" +
                "2- Review Refund Requests \n" +
                "3-Log out \n"+
                "Enter your choice:");
        p=scan.nextInt();
        switch(p)
        {
            case 1:
            {
                sp = new SpecificDiscount();
                System.out.println("1-set Specific Discount");
                System.out.println("2-set Overall Discount");
                k=scan.nextInt();
                if(k==1)
                {
                    //this will set specific discounts to each service in the pay form
                    System.out.println("which Service would you like to discount: \n" +
                            "1- Mobile Recharge Services.\n" +
                            "2- Internet Payment Services.\n" +
                            "3- Landline Services.\n" +
                            "4- Donations.");
                    qq = scan.nextInt();
                    System.out.println("how much discount would you'd like to add Ex:20");
                    pp = scan.nextInt();
                    if(qq == 1)
                    {
                        sp.SetDiscount(pp,0,0,0,1);
                    }
                    else if(qq == 2)
                    {
                        sp.SetDiscount(0,pp,0,0,2);
                    }
                    else if(qq == 3)
                    {
                        sp.SetDiscount(0,0,pp,0,3);
                    }
                    else if(qq == 4)
                    {
                        sp.SetDiscount(0,0,0,pp,4);
                    }
                    FormViewer(q);
                }
                else if(k==2)
                {
                    //this will set the overall discount in the pay form
                    System.out.println("how much discount would you'd like to add Ex:20");
                    ss = scan.nextInt();
                    ov = new OverAllDiscount();
                    ov.SetDiscount(ss,0,0,0,0);
                    FormViewer(q);
                }
                FormViewer(q);
                break;
            }
            case 2:
            {  // this part manages the refunds requests
                r = new RefundReply();
                r.RequestResponse(q);
                FormViewer(q);
                break;
            }
            case 3:
            {
                //this will return to the log in menu
                s = new Startup();
                s.StartingMenu();
                break;
            }
            default:
                FormViewer(q);
        }
    }
}
