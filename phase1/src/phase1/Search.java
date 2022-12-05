package phase1;
import java.util.Scanner;

public class Search
{
    public void searching (Users q) // this part responsible for  searching for services by name
    {
        Services m;
        String sname;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the service you want to search for(small characters) ex: mobile services");
        sname = scan.nextLine();

        if(sname.equals("mobile services")) // this part displays mobile services and executes it 
        {
                m = new MobileServices();
                m.Execute(q);

        }
        else if(sname.equals("internet services")) // this part displays internet services and executes it 
        {
                m = new InternetServices();
                m.Execute(q);

        }
        else if (sname.equals("landline services")) // this part displays landline services and executes it
        {
                m = new LandlineServices();
                m.Execute(q);

        }
        else if (sname.equals("donations")) // this part displays donations services and executes it 
        {
                m = new DonationServices();
                m.Execute(q);

        }
    }
}

