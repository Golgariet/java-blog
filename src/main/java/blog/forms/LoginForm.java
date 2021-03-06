package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    @Size(min=2, max=30, message = "USERNAME SIZE SHOULD BE IN RANGE OF 2-30")
    private String username;

    @NotNull
    @Size(min=1, max=50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}