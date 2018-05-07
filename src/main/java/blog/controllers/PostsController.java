package blog.controllers;

import blog.forms.PostForm;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts/create")
    public String CreatePostForm(PostForm PostForm){
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPostPage(@Valid PostForm PostForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "posts/create";
        }

        notifyService.addInfoMessage("Post created successfully!");
        return "redirect:/";
    }

    @RequestMapping("/posts")
    public String posts(Model model){
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/posts";
    }
}