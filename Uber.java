package Uber;
import java.util.ArrayList;
import java.util.Scanner;

import offer.ride;
import userspack.admin;
import userspack.client;
import userspack.driver;
import userspack.user;

public class Uber {
	public static user loggedIn = null;
    public static ArrayList<driver> pendingRegistrations=new ArrayList<driver>();
    public static ArrayList<user> suspendedUsers=new ArrayList<user>(); // if  the admin suspended any user , this user will add to the list and cannot be able to login
    public static ArrayList<user> registeredUsers=new ArrayList<user>() ;
    public static ArrayList<driver> drivers =new ArrayList<driver>();
    public static ArrayList<client> clients=new ArrayList<client>();
    public static ArrayList<ride> rides=new ArrayList<ride>() ;
    private static admin systemAdmin = new admin("mohamed","123123123","password","email");
    public static void storeUser(user u){
        registeredUsers.add(u);
        if(u instanceof driver) {
            drivers.add((driver) u);
            registeredUsers.add(u);
        }
        if(u instanceof client) {
            clients.add((client) u);
            registeredUsers.add(u);
        }
        System.out.println("User is successfully registered");
    }
    public static boolean searchDriver(String username){
        for(driver driver : drivers){
            if(driver.getusername().equals(username)) return true;
        }
        return false;
    }
    static void displayMenu() {
        System.out.println("1-register .");
        System.out.println("2-sign in.");
        System.out.println("3-exit .");
    }
    public static void displayClientMenu(){
        System.out.println("1-request Ride.");
        System.out.println("2-view Offers.");
        System.out.println("3-add Rating.");
        System.out.println("4-back.");
        choice = input.nextInt();
        while (choice!=4){
            if (choice==1){
                System.out.println("enter source and destination area names.");
                String source;
                String destination;
                source = input.next();
                destination = input.next();
                ((client) loggedIn).requestRide(source,destination);
            }
            if (choice==2){
                ((client) loggedIn).viewOffers();
            }
            if (choice==3){
                System.out.println("Enter driver's name .");
                String name;
                int rating;
                name = input.next();
                if (searchDriver(name)){
                    for (driver driver: Uber.drivers){
                        if (driver.getusername().equals(name)){
                            System.out.println("enter your rating from 1 to 5 .");
                            rating = input.nextInt();
                            if (rating >0 && rating <5){
                                ((client) loggedIn).addRating(driver,rating);
                                System.out.println("rating added successfully .");
                            }
                            else {
                                System.out.println("wrong number, please try again.");
                            }
                        }
                    }
                }
                else {
                    System.out.println("There is no such driver in the system");
                }
            }
            displayClientMenu();
        }
    }
    public static void displayDriverMenu(){
        System.out.println("1-list Rides in Favourite Area.");
        System.out.println("2-display Rating List.");
        System.out.println("3-add favourite area.");
        System.out.println("4-back.");
        choice = input.nextInt();
        while (choice!=4){
            if (choice==1) {
                System.out.println("Enter source area name.");
                String source;
                source = input.next();
                ((driver) loggedIn).listRides(source);
                System.out.println("////////////////////////");
                System.out.println("1-suggest Price for ride");
                System.out.println("2- Back");
                choice = input.nextInt();
                if (choice==1){
                    double price;
                    int rideID;
                    rideID = input.nextInt();
                    price = input.nextDouble();
                    System.out.println("enter price.");
                    ((driver) loggedIn).suggestPrice(price,rideID);
                    displayDriverMenu();
                }
                if (choice==2){
                    displayDriverMenu();
                }
            }
            if (choice==2) {

                ((driver) loggedIn).showRatingList();
            }

        }

        displayMenu();
    }
    public static void displayAdminMenu(){
        System.out.println("1-list Pending Registration for Drivers.");
        System.out.println("2-suspend User .");
        System.out.println("3-unSuspend User.");
        System.out.println("4-back.");
        choice = input.nextInt();
        while (choice!=4){
            if (choice==1){
                systemAdmin.listPendingRegistrations();
                System.out.println("1-choose Driver To approve or reject.");
                System.out.println("2-back.");
                choice=input.nextInt();
                if (choice==1){
                    System.out.println("enter driver's user name");
                    String name = input.next();
                    for (driver driver: pendingRegistrations){
                        if (driver.getusername().equals(name)){
                            System.out.println("1-approve driver.");
                            System.out.println("2-reject driver.");
                            choice=input.nextInt();
                            if (choice==1){
                                systemAdmin.acceptRegistration(name);
                                break;
                            }
                            if (choice==2){
                                systemAdmin.rejectRegistration(name);
                                break;
                            }
                        }
                    }
                }
                if (choice==2){
                    displayAdminMenu();
                }
            }
            if (choice==2){
                System.out.println("enter user' name");
                String name = input.next();
                for (user user :registeredUsers){
                    if (user.getusername().equals(name)){
                        systemAdmin.suspendUser(user);
                        systemAdmin.suspendUser(user.getusername());
                        System.out.println("suspended successfully");
                    }
                    else {
                        System.out.println("user not found");

                    }
                    displayAdminMenu();
                }
            }
            if (choice==3){
                System.out.println("enter User' name");
                String name = input.next();
                for (user user :suspendedUsers){
                    if (user.getusername().equals(name)){
                        systemAdmin.unSuspendUser(user);
                        systemAdmin.unSuspendUser(user.getusername());
                    }
                    else {
                        System.out.println("user not found");
                    }
                }
                displayAdminMenu();
            }
            if (choice==4){
                return;
            }
        }
    }
    public static boolean searchSuspended(String userName){
        for (user user: suspendedUsers){
            if (user.getusername().equals(userName)){
                return true;
            }
        }
        return false;
    }
    public static boolean login(String userName, String password){
        boolean status=false;
        if(systemAdmin.getusername().equals(userName)&&systemAdmin.getPassword().equals(password)){
            displayAdminMenu();
            System.out.println("admin log in successfully");
            status=true;
        }
        else if (searchSuspended(userName)){
            System.out.println("you have been suspended by admin");
        }
        else if (searchRegisteredUser(userName)){
            for(user u : registeredUsers){
                if(u.getusername().equals(userName) && u.getPassword().equals(password) ){
                    loggedIn = u;
                    System.out.println("logged in successfully");
                    status=true;
                }
            }
        }
        else{
            System.out.println("user not found");
            status=false;
        }
        return status;
    }
    public static boolean searchRegisteredUser(String username){
        for(user u : registeredUsers){
            if(u.getusername().equals(username))
                return true;
        }
        return false;
    }
    static void register(int ch){
        if (ch==1){
            System.out.println("enter your data as: USERNAME, MOBILE NUMBER, PASSWORD, EMAIL");
            String userName = input.next();
            String mobileNumber = input.next();
            String password = input.next();
            String email = input.next();
            client client = new client(userName,mobileNumber,password,email);
            storeUser(client);
        }
        if (ch==2){
            System.out.println("enter your data as: USERNAME, MOBILE NUMBER, PASSWORD, EMAIL, NATIONAL ID, DRIVING LICENCE");
            String userName = input.next();
            String mobileNumber = input.next();
            String password = input.next();
            String email = input.next();
            String nationalID = input.next();
            String drivingLicence = input.next();
            driver driver = new driver(userName,mobileNumber,password,email,nationalID,drivingLicence);
            admin.addPendingRegistrations(driver);
        }
    }
    static Scanner input = new Scanner(System.in);
    static int choice;
    static int ip;

    public static void main(String[] args) {
        System.out.println("welcome to transport Uber app");
        displayMenu();
        do {
            choice = input.nextInt();
            //REGISTRATION
            if (choice == 1) {
                System.out.println("1-CLIENT");
                System.out.println("2-DRIVER.");
                System.out.println("3-BACK.");
                ip = input.nextInt();
                while (ip != 3) {
                    register(ip);
                    break;
                }
            }
            // signIn
            if (choice == 2) {
                System.out.println("enter your username and password");
                String userName = input.next();
                String password = input.next();
                boolean status =login(userName,password);
                boolean suspended = false;
                boolean status1 = false;
                for (user user : suspendedUsers){
                    if(user.getusername().equals(userName)){
                        suspended = true;
                    }
                }
                if(!suspended) {status1 =login(userName,password);}else{
                    System.out.print("user is suspended");
                    status1 = false;
                }
                if (status1){
                    if (loggedIn instanceof client){
                        displayClientMenu();
                    }
                    if (loggedIn instanceof driver){
                        displayDriverMenu();
                    }
                    if (loggedIn instanceof admin){
                        displayAdminMenu();
                    }
                }
            }
            
            if (choice == 3) {
            	System.exit(0);
            }
            displayMenu();
        }
        while (choice != 3);
    }
}
