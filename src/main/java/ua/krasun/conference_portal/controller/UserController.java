package ua.krasun.conference_portal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.krasun.conference_portal.service.UserService;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public String main(@RequestParam(required = false) String findName, Model model) {
        model.addAttribute("users", userService.findByName(findName));
        model.addAttribute("filter", findName);
        return "userList";
    }

    @GetMapping("/sortBy/{param}")
    public String sortByName(@PathVariable String param, Model model) {
        model.addAttribute("users", userService.sortBy(param));
        return "userList";
    }
}
