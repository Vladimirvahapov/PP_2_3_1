package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("allusers", userService.getAllUsers());
        return "/users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping(value = "/edit")
    public String editUser(@RequestParam("userId") int userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "/new";
    }

    @PostMapping(value = "/createUser")
    public String create(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.createUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("userId") int userId) {
        userService.deleteUserById(userId);
        return "redirect:/users";
    }

}
