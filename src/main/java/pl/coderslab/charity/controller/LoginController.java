package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;

    private final UserRepository userRepository;

    public LoginController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) Boolean error) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "adm/login";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    @GetMapping("/logout")
    public String logout(){
        return "adm/logout";
    }
    @PostMapping("/logout")
    public String loggedout(){
        return "/";
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/add";
    }
    @PostMapping("/create-user")

    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username","error.username","username already in use");
            return "users/add";
        }
        if (result.hasErrors()) {
            return "users/add";
        }
        userService.saveUser(user);
        return "redirect:/";
    }


}
