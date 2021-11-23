public class Rider extends User{
    
    public Rider(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password);
    }
    
    public RideTrip requestRideTrip(String source, String destination){
        return new RideTrip(source, destination, this);
    }
  
}
