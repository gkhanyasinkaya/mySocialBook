import java.util.ArrayList;
import java.util.Date;

public class User{
    //User Properties
    private static int userIDcounter = 0;
    private int userID;
    private String name;
    private String userName;
    private String passw;
    private Date bDay;
    private String gradSchool;


    ArrayList<User> Friends = new ArrayList<User>();
    ArrayList<User> blockedFriends = new ArrayList<User>();
    ArrayList<User> blockedUsers = new ArrayList<User>();



    public User(){}
    public User(String userName,String passw){
        this.userName = userName;
        this.passw = passw;
    }
    public User(String name, String userName,String passw, Date bDay, String gradSchool) {
        this.userID = ++userIDcounter;
        this.name = name;
        this.userName = userName;
        this.passw = passw;
        this.bDay = bDay;
        this.gradSchool = gradSchool;

    }

    // GET & SET METHODS;
    // UserID
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    // Full Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Username
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    // Password
    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }


    // Birthday
    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }


    // Graduated School
    public String getGradSchool() {
        return gradSchool;
    }

    public void setGradSchool(String gradSchool) {
        this.gradSchool = gradSchool;
    }

/*
    // Friends
    public ArrayList<User> getFriends() {
        return Friends;
    }

    public void setFriends(ArrayList<User> friends) {
        Friends = friends;
    }


    //Blocked Friends;
    public ArrayList<User> getBlockedFriends() {
        return blockedFriends;
    }

    public void setBlockedFriends(ArrayList<User> blockedFriends) {
        this.blockedFriends = blockedFriends;
    }


    //Blocked User;
    public ArrayList<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }
*/
}
