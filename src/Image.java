import java.util.Date;
import java.util.List;

public class Image  extends Post{
    private String nameofImage;
    private String sizeofImage;

    public Image(int userID, String postText, Location postLoc, Date postDate, List<String> taggedFriends, String nameofImage, String sizeofImage,String postType) {
        super(userID, postText, postLoc, postDate, taggedFriends,postType);
        this.nameofImage = nameofImage;
        this.sizeofImage = sizeofImage;
    }

    public String getNameofImage() {
        return nameofImage;
    }

    public void setNameofImage(String nameofImage) {
        this.nameofImage = nameofImage;
    }

    public String getSizeofImage() {
        return sizeofImage;
    }

    public void setSizeofImage(String sizeofImage) {
        this.sizeofImage = sizeofImage;
    }



}
