package eu.ensup.controller;

import eu.ensup.dao.UserRepository;
import eu.ensup.domaine.User;
import eu.ensup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String home(Model model){
        /*User user = userService.findUser(new User("johndoe", "johndoe"));
        model.addAttribute("user", user);*/
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/signin")
    public String signin(User user,Model model){
        User fetchuser = userService.findUser(user);
        if(fetchuser == null){
            model.addAttribute("message", "Le mail ou le mot de passe est incorrect");
            return "index";
        }
        else
        {
            model.addAttribute("user", user);
            return "home";
        }
    }

    @PostMapping("/signup")
    public String signup(User user,Model model){

        return "index";
    }


}
