import java.util.ArrayList;
import java.util.Date;

public class UserMethods{
    public void AddFriends(User user,User friend){
        if(friend.getUserName().isEmpty()){}
        user.Friends.add(friend);

    }

    public void RemoveFriends(User user, User friend){
        user.Friends.remove(friend);
    }

    public void ShowFriends(User user){
        for (User loopvar : user.Friends){
            System.out.println("Name: "+loopvar.getName());
            System.out.println("Username: "+loopvar.getUserName());
            System.out.println("Date of Birth: "+loopvar.getbDay());
            System.out.println("Graded School: "+loopvar.getGradSchool());
            System.out.println("-------------");
        }
    }

    public void blockUsers(User user,User blocked){
        ArrayList<User> AllUsers = new ArrayList<User>();
        UsersDataBase DB = new UsersDataBase();
        for (User loopvar : user.Friends){
            if (loopvar == blocked){
                user.blockedFriends.add(blocked);
                RemoveFriends(user,blocked);
                break;
            }
        }
        for (User loopvar : DB.AllUsers){
            if (loopvar == blocked){
                user.blockedUsers.add(blocked);

            }
        }
    }



    public void unblockUsers(User user,User blocked){
        for (User loopvar : user.blockedFriends){
            if (loopvar == blocked){
                user.blockedFriends.remove(blocked);
                break;
            }
        }
        for (User loopvar : user.blockedUsers){
            if(loopvar == blocked){
                user.blockedUsers.remove(blocked);
                break;
            }
        }
    }

    public void ShowBlockedUsers(User user){
        DateFormatter conv = new DateFormatter();
        if (user.blockedUsers!=null){
            for (User loopvar : user.blockedUsers){
                System.out.println("Name: "+loopvar.getName());
                System.out.println("username: "+loopvar.getUserName());
                System.out.println("Date of birth: "+ conv.DateToString(loopvar.getbDay()));
                System.out.println("Graduated School: "+loopvar.getGradSchool());
                System.out.println("-------------");
            }
        }else{
            System.out.println("No such user in your blocked-user list!");
        }
    }


    public void ShowBlockedFriends(User user){
        DateFormatter conv = new DateFormatter();
        if (user.blockedFriends!=null){
            for (User loopvar : user.blockedFriends){
                System.out.println("Name: "+loopvar.getName());
                System.out.println("username: "+loopvar.getUserName());
                System.out.println("Date of birth: "+ conv.DateToString(loopvar.getbDay()));
                System.out.println("Graduated School: "+loopvar.getGradSchool());
                System.out.println("-------------");
            }
        }else{
            System.out.println("No such user in your blocked-friends list!");
        }
    }


    public void ChangePW(User user,String newPW){
        if (newPW.equals(user.getPassw())){
            user.setPassw(newPW);
        }
        else{
            System.out.println("Password mismatch!");
            System.out.println("-------------");
        }
    }


    public void UpdateInfo(User user,String newName,Date newDate,String newSchool){
        user.setUserName(newName);
        user.setbDay(newDate);
        user.setGradSchool(newSchool);

    }


}
