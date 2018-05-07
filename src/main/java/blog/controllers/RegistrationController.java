package blog.controllers;

import blog.forms.RegistrationForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value="/users/register")
    public String register(RegistrationForm registrationForm){
        return "users/register";
    }

    @RequestMapping(value= "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        notifyService.addInfoMessage("Registration is successful");
        return "redirect:/";
    }
}