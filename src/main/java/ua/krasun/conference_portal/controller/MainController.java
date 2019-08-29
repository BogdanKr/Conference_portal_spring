package ua.krasun.conference_portal.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.ConferenceService;

import java.time.LocalDate;

@Controller
public class MainController {
    private final ConferenceService conferenceService;

    public MainController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcomePage(@AuthenticationPrincipal User currentUser,
                              Model model){
        model.addAttribute("conferences", conferenceService.findAll(currentUser) );
        model.addAttribute("dateNow", LocalDate.now());
        return "welcome";
    }

    @RequestMapping("/testData")
    public String testData() {
        return "testData";
    }
}
