package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.ConferenceService;

import java.time.LocalDate;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/conference")
public class ConferenceController {
    @Autowired
    ConferenceService conferenceService;

    @PostMapping
    public String addConference(@AuthenticationPrincipal User currentUser,
                                @RequestParam("localDate")
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate,
                                @RequestParam String subject,
                                Model model) {
        conferenceService.addConference(localDate, subject, currentUser);
//        model.addAttribute("conferences", conferenceService.findAll());
        return "redirect:/welcome";
    }

    @GetMapping("{conference}")
    public String userEditForm(@PathVariable Conference conference, Model model) {

        model.addAttribute("conference", conference);
        model.addAttribute("conferences", conferenceService.findAll());
        return "welcome";
    }

    @PostMapping("/{conf}")
    public String updateConference(
                                @PathVariable Long conf,
                                @RequestParam("id") Conference conference,
                                @RequestParam("localDate")
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate,
                                @RequestParam("subject") String subject) {
        conferenceService.updateConference( conference, localDate, subject);
        return "redirect:/welcome";
    }
}
