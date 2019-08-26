package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.RegFormService;

import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegFormService regFormService;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Map<String, Object> model) {
        boolean userFromDb = regFormService.regUser(user);
        if (!userFromDb) {
            model.put("message", "User already exist ");
            return "registration";
        }
        model.put("message", "User successful registered");
        return "login";
    }
}
