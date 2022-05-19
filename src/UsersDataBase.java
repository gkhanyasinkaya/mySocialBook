import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UsersDataBase{

    ArrayList<User> AllUsers = new ArrayList<User>();
    public UsersDataBase(){}
    public void ReadingUserFile(){
        ReadFile rd = new ReadFile();
        DateFormatter DF= new DateFormatter();
        ArrayList<List> inputUser;
        try {
            inputUser = rd.ReadingFile("users.txt");
            for (List<String> i : inputUser) {
                User user = new User(i.get(0), i.get(1), i.get(2), DF.StringToDate(i.get(3)), i.get(4));
                AddtoAllUserList(user);
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }


    public void AddtoAllUserList(User user){
        AllUsers.add(user);
    }

    public void ShowAllUsers(){
        DateFormatter conv = new DateFormatter();
        System.out.println("-------------");
        for (User loopvar : AllUsers){
            System.out.println("Name: "+loopvar.getName());
            System.out.println("Usarname: "+loopvar.getUserName());
            System.out.println("Date of birth: "+ conv.DateToString(loopvar.getbDay()));
            System.out.println("Graduated School: "+loopvar.getGradSchool());
            System.out.println("-------------");
        }

    }
    public ArrayList<User> getAllUser(){
        return AllUsers;
    }

    public void RemoveUser(int ID){
        for (User i : AllUsers){
            if (ID == i.getUserID()) {
                this.AllUsers.remove(ID-1);
                break;
            }
            else{
                System.out.println("No such user!");
            }
        }
    }
}