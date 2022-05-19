import java.util.Date;
import java.util.List;

public class Video extends Post{
    public String nameofVideo;
    public String sizeofVideo;

    public Video(int userID, String postText, Location postLoc, Date postDate, List<String> taggedFriends, String nameofVideo, String sizeofVideo,String postType) {
        super(userID, postText, postLoc, postDate, taggedFriends,postType);
        this.nameofVideo = nameofVideo;
        this.sizeofVideo = sizeofVideo;
    }

    public String getNameofVideo() {
        return nameofVideo;
    }

    public void setNameofVideo(String nameofVideo) {
        this.nameofVideo = nameofVideo;
    }

    public String getSizeofVideo() {
        return sizeofVideo;
    }

    public void setSizeofVideo(String sizeofVideo) {
        this.sizeofVideo = sizeofVideo;
    }

}
