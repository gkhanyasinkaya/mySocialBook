import java.util.Date;
import java.util.List;

public class Text extends Post{
    public Text(int userID, String postText, Location postLoc, Date postDate, List<String> taggedFriends,String postType) {
        super(userID, postText, postLoc, postDate, taggedFriends,postType);
    }
}