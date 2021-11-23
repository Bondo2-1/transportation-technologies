

public class User {
	protected String username;
    protected String mobileNumber;
    protected String email;
    protected String password;
    protected boolean notify;
    
    public User(String username, String mobileNumber, String email, String password){
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getnotify() {
        return notify;
    }

    public void setnotify(boolean notify) {
        this.notify = notify;
    }
    
}
