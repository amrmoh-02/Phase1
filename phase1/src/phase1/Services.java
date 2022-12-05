package phase1;
public interface Services
{ // this interface manages applying different actions to the services provided by the system
  public void Execute(Users q);
  public void PrintServiceProvider();
  public String ChooseServiceProvider(Users q);
  public String AddDiscount(String k);

}

