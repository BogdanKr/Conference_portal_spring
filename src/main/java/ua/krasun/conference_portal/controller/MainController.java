package ua.krasun.conference_portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }

    @RequestMapping("/testData")
    public String testData() {
        return "testData";
    }
}
