import java.util.Date;
import java.util.List;

public  class Post{
    private static int postIDcounter = 0;
    private int postID;
    private int userID;
    private String postText;
    private Location postLoc;
    private Date postDate;
    private List<String> TaggedFriends;
    public String postType;


    public Post(){}
    public Post(int userID, String postText, Location postLoc, Date postDate, List<String> taggedFriends,String postType){
        this.postID = ++postIDcounter;
        this.userID = userID;
        this.postText = postText;
        this.postLoc = postLoc;
        this.postDate = postDate;
        this.TaggedFriends = taggedFriends;
        this.postType = postType;
    }


    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Location getPostLoc() {
        return postLoc;
    }

    public void setPostLoc(Location postLoc) {
        this.postLoc = postLoc;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public List<String> getTaggedFriends() {
        return TaggedFriends;
    }

    public void setTaggedFriends(List<String> taggedFriends) {
        TaggedFriends = taggedFriends;
    }





}
