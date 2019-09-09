package ua.krasun.conference_portal.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.entity.dto.ConferenceDto;
import ua.krasun.conference_portal.service.ConferenceService;

import java.time.LocalDate;

@Controller
public class MainController {
    private final ConferenceService conferenceService;

    public MainController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcomePage(@AuthenticationPrincipal User currentUser,
                              Model model,
                              @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC, size = 6) Pageable pageable,
                              @RequestParam(name = "page", required = false) Integer page) {
        Page<ConferenceDto> conferences = conferenceService.findAll(currentUser, pageable);
        int totalPage = conferences.getTotalPages();
        model.addAttribute("conferences", conferences);
        model.addAttribute("dateNow", LocalDate.now());
        model.addAttribute("url", "/welcome");
        if (page != null && ((page + 1) > totalPage)) {
            model.addAttribute("conferences", conferenceService.findAll(currentUser, pageable.first()));
        }
        return "welcome";
    }

    @RequestMapping("/conference_all")
    public String shoeAllConferences(@AuthenticationPrincipal User currentUser, Model model,
                                     Pageable pageable) {
        model.addAttribute("conferences", conferenceService.findAll(currentUser, pageable));
        return "conferencesList";
    }

    @RequestMapping("/my_registrations")
    public String userRegistrations(@AuthenticationPrincipal User currentUser,
                                    Model model, Pageable pageable) {
        model.addAttribute("conferences", conferenceService.findUserRegistrations(currentUser, pageable));
        return "conferencesList";
    }
}
