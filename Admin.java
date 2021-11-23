
import java.util.ArrayList;

public class Admin extends User{
    
    public Admin(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password);
    }
    
    public void ListPendingDrivers(ArrayList<Driver> drivers){
        for(int i=0; i<drivers.size(); i++){
            if(drivers.get(i).getAccountStatus().equals("Pending")){
                drivers.get(i).printDriver();
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
    
    public void activateDriverAccount(Driver driver){
        driver.setAccountStatus("Active");
    }
    
    public void deactivateDriverAccount(Driver driver){
        driver.setAccountStatus("Pending");
    }
}
