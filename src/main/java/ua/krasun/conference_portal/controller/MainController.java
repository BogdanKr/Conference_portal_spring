package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.krasun.conference_portal.service.ConferenceService;

@Controller
public class MainController {
    @Autowired
    ConferenceService conferenceService;

    @GetMapping
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcomePage(Model model){
        model.addAttribute("conferences", conferenceService.findAll() );
        return "welcome";
    }

    @RequestMapping("/testData")
    public String testData() {
        return "testData";
    }
}
