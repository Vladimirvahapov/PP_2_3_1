package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allusers", userService.getAllUsers());
        return "/index";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @GetMapping(value = "/edit")
    public String editUser(@RequestParam("userId") Integer userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "/edit";
    }

    @PostMapping(value = "/createUser")
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/updateUser")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("userId") Integer userId) {
        userService.deleteUserById(userId);
        return "redirect:/";
    }

}
