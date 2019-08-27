package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.ConferenceService;

import java.time.LocalDate;

@Controller
@RequestMapping("/conference")
public class ConferenceController {
    @Autowired
    ConferenceService conferenceService;

    @PostMapping
    public String addConference(@AuthenticationPrincipal User currentUser,
                                @RequestParam LocalDate date,
                                @RequestParam String subject,
                                Model model) {
        conferenceService.addConference(date, subject, currentUser);
        model.addAttribute("conferences",conferenceService.findAll());
        return "welcome";
    }
}
