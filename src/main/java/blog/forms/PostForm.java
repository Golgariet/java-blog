package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostForm {

    @NotNull
    @Size(max = 300, message = "Title length is maximum for 300 characters")
    private String title;

    @NotNull
    private String post;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;

    }

    public void setPost(String post) {
        this.post = post;
    }
}