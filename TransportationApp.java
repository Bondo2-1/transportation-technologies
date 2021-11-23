
import java.util.ArrayList;

public class TransportationApp {
        public static ArrayList<Rider> riders = new ArrayList<Rider>();
        public static ArrayList<Driver> drivers = new ArrayList<Driver>();
        public static ArrayList<RideTrip> rides = new ArrayList<RideTrip>();

    public static void main(String[] args) {
        Admin adminUser = new Admin("admin", "0111111111", "admin@example.com", "admin");
        System.out.println("Admin User Created");
        System.out.println("-------------------------------------------------------------");
        
        Rider testUser = new Rider("ahmed", "0123456789", "ahmed@example.com", "12345");
        riders.add(testUser);
        System.out.println("Rider 1 User Created");
        System.out.println("-------------------------------------------------------------");
        
        Rider testUser2 = new Rider("mohamed", "0122222222", "mohamed@example.com", "67890");
        riders.add(testUser2);
        System.out.println("Rider 2 User Created");
        System.out.println("-------------------------------------------------------------");
        
        Driver testDriver = new Driver("dirver1", "9999999999", "driver1@example.com", "aaaaa", "EG1738", "092388393883");
        testDriver.addFavoriteArea("Fisal");
        drivers.add(testDriver);
        System.out.println("Driver 1 User Created");
        System.out.println("-------------------------------------------------------------");
        
        Driver testDriver2 = new Driver("dirver2", "888888888", "driver2@example.com", "bbbbb", "EG1922", "098371938093");
        testDriver2.addFavoriteArea("Nasr City");
        drivers.add(testDriver2);
        System.out.println("Driver 2 User Created");
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Listing All Pending Drivers");
        adminUser.ListPendingDrivers(drivers);
        
        adminUser.activateDriverAccount(testDriver);
        System.out.println("Driver 1 Account Activated");
        System.out.println("-------------------------------------------------------------");
        adminUser.activateDriverAccount(testDriver2);
        System.out.println("Driver 2 Account Activated");
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Requesting a Ride by Rider 1 from Fisal to Heliopolis");
        rides.add(testUser.requestRideTrip("Fisal", "Heliopolis"));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Requesting a Ride by Rider 2 from Nasr City to Rehab");
        rides.add(testUser2.requestRideTrip("Nasr City", "Rehab"));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Listing All Rides in Favorite Areas for Driver 1");
        testDriver.ListRidesInFavoriteAreas(rides, testDriver.getFavoriteAreas().get(0));
        
        System.out.println("Listing All Rides in Favorite Areas for Driver 2");
        testDriver2.ListRidesInFavoriteAreas(rides, testDriver2.getFavoriteAreas().get(0));
        
        System.out.println("Driver 1 Added Offer for Ride 1 with EGP 100");
        rides.get(0).addSuggestedOffer(new Offer(100, testDriver));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Driver 2 Added Offer for Ride 2 with EGP 80");
        rides.get(1).addSuggestedOffer(new Offer(80, testDriver2));
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Listing all Ride Offers for Rider 1");
        rides.get(0).listAllOffers();
        
        System.out.println("Listing all Ride Offers for Rider 2");
        rides.get(1).listAllOffers();
    }
    
}
