package phase1;
import java.util.Scanner;


public class Startup // this part is responsible for creating users
{
    static Users [] u = new Users [100];
    static int counter = 1;
    public void InitializeUsers()
    {
        RefundReply k = new RefundReply();
        for (int i = 1; i < 100; i++)
        {
            u[i] = new Users();
        }
        for (int i = 0; i < 100; i++)
        {
            k.Requestee[i] = new Users();
        }
    }
    public Users SignInChecker(String mail, String passwd) // this part checks for mail and password
    {
        for (int i = 1;i < 100; i++)
        {
            if(u[i].Email.equals(mail) && u[i].Password.equals(passwd))
            {
                return u[i];
            }
        }
        return null;
    }
    public boolean SignUpChecker(String mail)
    {
        boolean flag = true;
        for (int i = 1;i < 100; i++)
        {
            if(u[i].Email.equals(mail))
            {
                flag = false;
            }

        }
        if (flag)
        {
            //email doesn't exist create, user can use it
            return true;
        }
        else
        {
            //email already exists don't create
            return false;
        }    }

    public void StartingMenu() // this part displays the starting menu
    {
        Menu m;
        Scanner scan = new Scanner(System.in);
        int k, j;
        String username, email,paaswd,adminpass = "1234",Pass;

        System.out.println(
                "1-Enter as User \n" +
                "2-Enter as Admin \n" +
                "3-Exit \n" +
                "Enter your choice:");
        k = scan.nextInt();

        if (k==1) // this is the user log in menu
        {
            System.out.println("enter 1 to sign in or 2 or sign up");
            j = scan.nextInt();
            if (j == 1) {
                scan.nextLine();
                System.out.println("Enter email");
                email = scan.nextLine();
                System.out.println("Enter password");
                paaswd = scan.nextLine();
                Users r;
                r = SignInChecker(email,paaswd);
                if(r != null)
                {
                    m = new UserMenu();
                    m.FormViewer(r);
                }
                else
                {
                    System.out.println("Wrong Email or password");
                    StartingMenu();
                }
            }
            else
            {
                System.out.println("Enter Username");
                scan.nextLine();
                username = scan.nextLine();
                System.out.println("Enter email");
                email = scan.nextLine();
                System.out.println("Enter password");
                paaswd = scan.nextLine();

                if (SignUpChecker(email))
                {
                    u[counter].setUser(username,email,paaswd);
                    counter++;
                    System.out.println("User Created");
                    StartingMenu();
                }
                else
                {
                    System.out.println("Email already exists");
                    StartingMenu();
                }
            }
        }
        else if(k==2) // this is the admin log in menu
        {
             scan.nextLine();
             System.out.println("Enter admin password");
             Pass = scan.nextLine();
            //check if admin password true(in admin file)
            if (adminpass.equals(Pass))
            {
                u[0] = new Users();
                u[0].setUser("admin"," "," ");
                m = new AdminMenu();
                m.FormViewer(u[0]);
            }
            else
            {
                System.out.println("Password incorrect");
                StartingMenu();
            }
            
        }
        else if (k==3)
        {
            return;
        }
    }
}
