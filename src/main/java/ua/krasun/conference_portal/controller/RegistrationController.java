package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserService userService;

    @GetMapping
    public String registration() {
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

    @GetMapping("{user}")
    public String userEditForm(@AuthenticationPrincipal User currentUser,
                               @PathVariable User user, Model model) {
        if (currentUser.equals(user) || currentUser.isAdmin()) {
            model.addAttribute("usr", user);
            model.addAttribute("roles", userService.roleTypeList());
            return "userEdit";
        }
        return "redirect:/welcome";
    }

    @PostMapping("/edit")
    public String userSaveEdit(
            @RequestParam String firstName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) boolean active,
            @RequestParam(required = false) String roleType,
            @RequestParam("userId") User user) {
            userService.userEdit(firstName, email, password, active, roleType, user);
        return "redirect:/welcome";
    }

}
