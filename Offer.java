

public class Offer {
    private float price;
    private Driver driver;
    
    public Offer(float price, Driver driver){
        this.price = price;
        this.driver = driver;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
