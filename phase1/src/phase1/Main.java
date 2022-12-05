package phase1;
public class Main
{
    public static void main(String[] args) // main function to run the system
    {

        Startup s1 = new Startup();
        //this will initialize the users
        s1.InitializeUsers();
        //this will call the primary form
        s1.StartingMenu();
    }
}