import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        // Declarations of methods
        ReadFile rd2 = new ReadFile();
        UserMethods userMet = new UserMethods();
        DateFormatter DF = new DateFormatter();
        UsersDataBase userDB = new UsersDataBase();
        LoginScreen logSc = new LoginScreen();

        ArrayList<Post> posts = new ArrayList<Post>();
        PostDataBase postDB = new PostDataBase(posts);

        boolean flag = false;
        User user2 = new User();
        User signed_user = new User();

        userDB.ReadingUserFile();// For Reading user.txt
        ArrayList<List> commands = rd2.ReadingFile("commands.txt"); // For Reading commands.txt
        for (List<String> z : commands) {
            String command= z.get(0),Command2= z.get(0);
            switch (command) {
                case "ADDUSER":
                    System.out.println("Command: "+z); // For printing commands
                    User user = new User(z.get(1), z.get(2), z.get(3), DF.StringToDate(z.get(4)), z.get(5));
                    userDB.AddtoAllUserList(user);
                    System.out.println(user.getUserName() + " has been successfully added.\n----------");
                    break;

                case "REMOVEUSER":
                    System.out.println("Command: "+z);
                    int id = Integer.parseInt(z.get(1));
                    userDB.RemoveUser(id);
                    System.out.println("User has been successfully removed.\n----------");
                    break;
                case "SIGNIN":
                    System.out.println("Command: "+z);
                    user2.setUserName(z.get(1));
                    user2.setPassw(z.get(2));
                    if (logSc.singIn(user2,userDB)) {
                        flag = true; // Usage of flag to control SignIn method in every comment
                        for (User u : userDB.getAllUser()) {
                            if (u.getUserName().equals(user2.getUserName()) ) {
                                User signed_User = u;
                            }
                        }
                    }
                    System.out.println("-------------");
                    break;
                case "SIGNOUT":
                    if (flag){
                        System.out.println("Command: "+z);
                        logSc.singOut(signed_user);
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }
                case "LISTUSERS":
                    if(flag){
                        System.out.println("Command: "+z);
                        userDB.ShowAllUsers();
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        break;
                    }

                case "UPDATEPROFILE":
                    System.out.println("Command: "+z);
                    if(flag) {
                        userMet.UpdateInfo(user2, z.get(1), DF.StringToDate(z.get(2)), z.get(3));
                    }  else{
                        System.out.println("Error: Please sign in and try again.");}
                    System.out.println("-------------");
                    break;
                case "CHPASS":
                    System.out.println("Command: "+z);
                    if(flag) {
                        userMet.ChangePW(signed_user, z.get(2));
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                    }
                    break;
                case "ADDFRIEND":
                    System.out.println("Command: "+z);
                    if(flag){
                        User friend = new User();
                        boolean flag2 = true;
                        for(User u: userDB.AllUsers){ // Checking if the 'user' exist or not exist.
                            if(u.getUserName().equals(z.get(1))){
                                friend=u;
                                flag2=false;
                                break;
                            }
                        }
                        if(flag2){
                            System.out.println("No such user!"); // if not exist.
                            System.out.println("-------------");
                            break;
                        }
                        for(User u : signed_user.Friends){ // Checking user is already in friendlist or not
                            if(friend.getUserName().equals(u.getUserName())){
                                System.out.println("This user is already in your friend list!");
                                System.out.println("-------------");
                                flag2 = true;
                                break;
                            }
                        }
                        if (flag2){
                            break;
                        }
                        else{
                            userMet.AddFriends(signed_user,friend);
                            System.out.println(friend.getUserName()+" has been successfully added to your friend list.");
                            System.out.println("-------------");
                            break;
                        }
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }
                case "REMOVEFRIEND":
                    System.out.println("Command: "+z);
                    if(flag){
                        User friend = new User();
                        boolean flag3 = true;
                        for(User u: userDB.AllUsers){
                            if(u.getUserName().equals(z.get(1))){
                                friend=u;
                                flag3=false;
                                break;
                            }
                        }
                        if(flag3){
                            System.out.println("No such user!");
                            System.out.println("-------------");
                            break;
                        }
                        for(User u : signed_user.Friends){
                            if(friend.getUserName().equals(u.getUserName())){
                                flag3 = true;
                                break;
                            }
                        }
                        if (flag3){
                            userMet.RemoveFriends(signed_user,friend);
                            System.out.println(friend.getUserName()+" has been successfully removed from your friend list.");
                            System.out.println("-------------");
                            break;
                        }
                        else{
                            System.out.println("No such friend!");
                            System.out.println("-------------");
                            break;
                        }
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }
                case "ADDPOST-TEXT":
                    System.out.println("Command: "+z);
                    if (flag){
                        String postType = "TXT";
                        double a = Double.parseDouble(z.get(2)); // Creating location value
                        double b = Double.parseDouble(z.get(3));
                        Location loc = new Location();
                        loc.latitude = a;
                        loc.longtitude = b;
                        String tag = z.get(4);
                        String[] arrOfStr = tag.split(":", -2); // Converting tagged friends command to list
                        List<String> taggedTX = Arrays.asList(arrOfStr);
                        ArrayList<String> tag2 = new ArrayList<String>();
                        for(String  u : taggedTX){
                            boolean flag3 = true;
                            for(User i : signed_user.Friends){
                                if(u.equals(i.getUserName())){
                                    flag3 = false;
                                    tag2.add(u);
                                    break;
                                }
                            }
                            if(flag3){
                                System.out.println(u+" is not your friend, and will not be tagged!");
                                break;
                            }
                        }
                        Text text = new Text(signed_user.getUserID(),z.get(1),loc,DF.GetDate(),tag2,postType);
                        postDB.AddPost(text);
                        System.out.println("The post has been successfully added.");
                        System.out.println("-------------");
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }

                case "ADDPOST-IMAGE":
                    System.out.println("Command: "+z);
                    if (flag){
                        String postType = "PNG";
                        double aIM = Double.parseDouble(z.get(2));
                        double bIM = Double.parseDouble(z.get(3));
                        Location locIM = new Location();
                        locIM.latitude = aIM;
                        locIM.longtitude = bIM;

                        String tagIM = z.get(4);
                        String[] arrOfStrIM = tagIM.split(":", -2);
                        List<String> taggedIM = Arrays.asList(arrOfStrIM);
                        ArrayList<String> tag2 = new ArrayList<String>();
                        for(String  u : taggedIM){
                            boolean flag3=true;
                            for(User i : signed_user.Friends){
                                if(u.equals(i.getUserName())){
                                    flag3 = false;
                                    tag2.add(u);
                                    break;
                                }
                            }
                            if(flag3){
                                System.out.println(u+" is not your friend, and will not be tagged!");
                            }
                        }
                        Image image = new Image(signed_user.getUserID(),z.get(1),locIM,DF.GetDate(),tag2,z.get(5),z.get(6),postType);
                        postDB.AddPost(image);
                        System.out.println("The post has been successfully added.");
                        System.out.println("-------------");
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }

                case "ADDPOST-VIDEO":
                    System.out.println("Command: "+z);
                    if(flag){
                        String postType = "MP4";
                        double aVI = Double.parseDouble(z.get(2));
                        double bVI = Double.parseDouble(z.get(3));
                        Location locVI = new Location();
                        locVI.latitude = aVI;
                        locVI.longtitude = bVI;
                        String tagVI = z.get(4);
                        String[] arrOfStrVI = tagVI.split(":", -2);
                        List<String> taggedVI = Arrays.asList(arrOfStrVI);
                        ArrayList<String> tag2 = new ArrayList<String>();
                        for(String  u : taggedVI){
                            boolean flag3=true;
                            for(User i : signed_user.Friends){
                                if(u.equals(i.getUserName())){
                                    flag3 = false;
                                    tag2.add(u);
                                    break;
                                }
                            }
                            if(flag3){
                                System.out.println(u+" is not your friend, and will not be tagged!");
                            }
                        }
                        Video video = new Video(signed_user.getUserID(),z.get(1),locVI,DF.GetDate(),tag2,z.get(5),z.get(6),postType);
                        postDB.AddPost(video);
                        System.out.println("The post has been successfully added.");
                        System.out.println("-------------");
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }

                case "REMOVELASTPOST":
                    System.out.println("Command: "+z);
                    if (flag){
                        postDB.RemoveLastPost();
                        System.out.println("Your last post has been successfully removed.");
                        System.out.println("-------------");
                        break;
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                        break;
                    }
                case "SHOWPOSTS":
                    ArrayList<Post> profile = new ArrayList<Post>();
                    User profile_user = new User();
                    for(User u:userDB.getAllUser()){
                        if(z.get(1).equals(u)){
                            profile_user = u;
                            break;
                        }
                    }
                    profile = postDB.GetAllPosts(profile_user);
                    System.out.println("**************\n"+z.get(1)+"'s Posts\n**************");
                    for(Post i : profile){
                        System.out.println(i.getPostText());
                        System.out.println("Date: "+i.getPostDate());
                        System.out.println("Location: "+i.getPostLoc().longtitude+" "+i.getPostLoc().latitude);
                        System.out.println("Friends tagged in this post: "+i.getTaggedFriends());
                        if(i.postType.equals("TXT")){
                            System.out.println("-------------");
                        }
                        else if(i.postType.equals("PNG")){
                            System.out.println("Image name: "+((Image) i).getNameofImage()); //casting to invoke methods
                            System.out.println("Image Res: "+((Image) i).getSizeofImage());
                            System.out.println("-------------");
                        }
                        else if(i.postType.equals("MP4")){
                            System.out.println("Video Name: "+((Video) i).getNameofVideo());
                            System.out.println("Minute of vide: "+((Video) i).getSizeofVideo());
                            System.out.println("-------------");
                        }

                    }
                    break;
                case "BLOCK":
                    System.out.println("Command: "+z);
                    if(flag) {
                        User blocked = new User();
                        boolean flag3 = true;
                        for (User u : userDB.AllUsers) {
                            if (u.getUserName().equals(z.get(1))) {
                                blocked = u;
                                flag3=false;
                                break;
                            }
                        }
                        if(flag3) {
                            System.out.println("No such user!");
                            System.out.println("-------------");
                            break;
                        }
                        for(User u : signed_user.blockedFriends){
                            if(blocked.getUserName().equals(u.getUserName())){
                                flag3 = true;
                                break;
                            }
                        }
                        if(flag3){
                            System.out.println("This friend already blocked.");
                            break;
                        }
                        for(User u : signed_user.blockedUsers){
                            if(blocked.getUserName().equals(u.getUserName())){
                                flag3 = true;
                                break;
                            }
                        }
                        if(flag3){
                            System.out.println("This user already blocked.");
                            break;
                        }
                        userMet.blockUsers(signed_user, blocked);
                        System.out.println(blocked.getUserName() + " has been successfully blocked.");
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        break;
                    }
                    System.out.println("-------------");
                    break;
                case "UNBLOCK":
                    System.out.println("Command: "+z);
                    if(flag) {
                        User unblocked = new User();
                        boolean flag3 = true;
                        for (User u : userDB.AllUsers) {
                            if (u.getUserName().equals(z.get(1))) {
                                unblocked = u;
                                flag3=false;
                                break;
                            }
                        }
                        if(flag3) {
                            System.out.println("No such user!");
                            System.out.println("-------------");
                            break;
                        }

                        for(User u : signed_user.blockedFriends){
                            if(unblocked.getUserName().equals(u.getUserName())){
                                userMet.unblockUsers(signed_user, unblocked);
                                System.out.println(unblocked.getUserName() + " has been successfully unblocked.");
                                flag3 = true;
                                break;
                            }
                        }
                        if(!flag3){
                            System.out.println("No such user in your blocked-friend list!");
                            System.out.println("-------------");
                            break;
                        }
                        for(User u : signed_user.blockedUsers){
                            if(unblocked.getUserName().equals(u.getUserName())){
                                userMet.unblockUsers(signed_user, unblocked);
                                System.out.println(unblocked.getUserName() + " has been successfully unblocked.");
                                flag3 = true;
                                break;
                            }
                        }
                        if(!flag3){
                            System.out.println("No such user in your blocked-user list!");
                            System.out.println("-------------");
                            break;
                        }
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        break;
                    }
                    System.out.println("-------------");
                    break;
                case "SHOWBLOCKEDFRIENDS":
                    System.out.println("Command: "+z);
                    if(flag) {
                        userMet.ShowBlockedFriends(signed_user);
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                    }
                    break;
                case "SHOWBLOCKEDUSERS":
                    System.out.println("Command: "+z);
                    if(flag) {
                        userMet.ShowBlockedUsers(signed_user);
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                    }
                    System.out.println("-------------");
                    break;
                case "LISTFRIENDS":
                    System.out.println("Command: "+z);
                    if(flag) {
                        userMet.ShowFriends(signed_user);
                    }else{
                        System.out.println("Error: Please sign in and try again.");
                        System.out.println("-------------");
                    }
                    break;
            }
        }
    }
}


