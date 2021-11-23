
import java.util.ArrayList;

public class RideTrip {
    private String source;
    private String destination;
    private Rider rider;
    private Driver driver;
    private Offer selectedOffer;
    
    private ArrayList<Offer> SuggestedOffers;
            
    public RideTrip(String source, String destination, Rider rider){
        this.source = source;
        this.destination = destination;
        this.rider = rider;
        this.driver = null;
        this.selectedOffer = null;
        
        SuggestedOffers  = new ArrayList<Offer>();
    }
    
    public void listAllOffers(){
        for(int i=0; i<SuggestedOffers.size(); i++){
            System.out.println("Price: "+SuggestedOffers.get(i).getPrice());
            System.out.println("Driver: "+SuggestedOffers.get(i).getDriver().getUsername());
            System.out.println("-------------------------------------------------------------");
        }
    }
    
    public void addSuggestedOffer(Offer offer){
        this.SuggestedOffers.add(offer);
    }
    
    public void printRideTrip(){
        System.out.println("Source: "+this.getSource());
        System.out.println("Destination: "+this.getDestination());
        System.out.println("Rider: "+this.getRider().getUsername());
    }
    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Offer getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(Offer selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public ArrayList<Offer> getSuggestedOffers() {
        return SuggestedOffers;
    }

    public void setSuggestedOffers(ArrayList<Offer> SuggestedOffers) {
        this.SuggestedOffers = SuggestedOffers;
    }
}
