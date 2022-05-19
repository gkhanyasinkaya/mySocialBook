import java.util.ArrayList;
import java.util.Date;

public class PostDataBase{
    ArrayList<Post> posts = new ArrayList<Post>();

    public PostDataBase(ArrayList<Post> posts){
        this.posts=posts;
    }

    public void AddPost(Post post){
        posts.add(post);
    }

    public void RemoveLastPost(){
        posts.remove(posts.size()-1);
    }

    public ArrayList<Post> GetAllPosts(User user){
        ArrayList<Post> profile = new ArrayList<Post>();
        for (Post i : posts) {
           if (user.getUserID() == i.getUserID()){
               profile.add(i);
           }
       }
        return profile;
    }

}

