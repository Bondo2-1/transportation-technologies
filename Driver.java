
import java.util.ArrayList;

public class Driver extends User{
    
    private String drivingLicense;
    private String nationalID;
    private String accountStatus;
    private ArrayList<String> favoriteAreas;
    private ArrayList<RideTrip> requsetedrides;
    
    public Driver(String username, String mobileNumber, String email, String password, String drivingLicense, String nationalID) {
        super(username, mobileNumber, email, password);
        this.drivingLicense = drivingLicense;
        this.nationalID = nationalID;
        this.accountStatus = "Pending";
        
        favoriteAreas = new ArrayList<String>();
        requsetedrides = new ArrayList<RideTrip>();
    }
    
    public void ListRidesInFavoriteAreas(ArrayList<RideTrip> rides, String favoriteArea){
        for(int i=0; i<rides.size(); i++){
            if(rides.get(i).getSource().equals(favoriteArea)){
                rides.get(i).printRideTrip();
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
    
    public void printDriver(){
        System.out.println("Username: "+this.getUsername());
        System.out.println("Mobile: "+this.getMobileNumber());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Driving License: "+this.getDrivingLicense());
        System.out.println("National ID: "+this.getNationalID());
    }

    public void addFavoriteArea(String area){
        favoriteAreas.add(area);
    }
    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }  
    
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }  

    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public void setFavoriteAreas(ArrayList<String> favoriteAreas) {
        this.favoriteAreas = favoriteAreas;
    }
    public void addrequestedrides(RideTrip x) {
    	for (int i=0;i<favoriteAreas.size();i++) {
    		if (favoriteAreas.get(i).equalsIgnoreCase(x.getSource())) {
    			requsetedrides.add(x);
    			notify=true;
    		}
    	}
    }
}
