package blog.services;
import blog.models.User;

import java.util.List;

public interface UserService {

    boolean authenticate(String username, String password);

    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);

}