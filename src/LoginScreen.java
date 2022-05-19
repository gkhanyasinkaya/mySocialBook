
import java.util.ArrayList;
import java.util.Date;

public class LoginScreen {
    public boolean singIn(User user,UsersDataBase DB) {
        for (User u :DB.getAllUser()) {
            if ( u.getPassw().equals(user.getPassw())  && u.getUserName().equals(user.getUserName()) ){
				System.out.println(user.getUserName()+" You have successfully signed in.");
                return true;
            }
        }
        
        System.out.println("The username and password you entered did not match our records. Please try again!");
        return false;
    }

    public void singOut(User user) {
            User nulluser= new User();
            user = nulluser;
            System.out.println("You have successfully signed out.");
    }

}
