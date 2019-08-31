package ua.krasun.conference_portal.controller;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.ConferenceService;

import org.springframework.data.domain.Pageable;
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
                              Model model,
                              @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC, size = 6) Pageable pageable){
        model.addAttribute("conferences", conferenceService.findAll(currentUser, pageable) );
        model.addAttribute("dateNow", LocalDate.now());
        model.addAttribute("url", "/welcome");
        return "welcome";
    }

    @RequestMapping("/conference_all")
    public String shoeAllConferences(@AuthenticationPrincipal User currentUser, Model model,
                                     Pageable pageable) {
        model.addAttribute("conferences", conferenceService.findAll(currentUser, pageable));
        return "conferencesList";
    }
}
