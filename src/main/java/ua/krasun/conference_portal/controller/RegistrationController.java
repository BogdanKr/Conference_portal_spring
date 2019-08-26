package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.UserService;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Map<String, Object> model) {
        boolean userFromDb = userService.regUser(user);
        if (!userFromDb) {
            model.put("message", "User already exist ");
            return "registration";
        }
        model.put("message", "User successful registered");
        return "login";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user_list")
    public String main(@RequestParam(required = false) String findName, Model model) {
        model.addAttribute("users", userService.findByName(findName));
        model.addAttribute("filter", findName);
        return "user_list";
    }

}
