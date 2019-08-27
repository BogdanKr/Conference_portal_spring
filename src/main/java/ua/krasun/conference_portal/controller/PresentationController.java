package ua.krasun.conference_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.Presentation;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.service.PresentationService;

@Controller
@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('SPEAKER')")
@RequestMapping("/presentation")
public class PresentationController {
    @Autowired
    PresentationService presentationService;

    @GetMapping("/{conference}")
    public String userEditForm(@PathVariable Conference conference,
                               Model model,
                               @RequestParam(required = false) Presentation presentation) {
        model.addAttribute("presentation", presentation);
        model.addAttribute("conference", conference);
        model.addAttribute("presentations", presentationService.findAll());
        return "presentationEdit";
    }

    @PostMapping("/{conference}")
    public String updateConference(@AuthenticationPrincipal User currentUser,
                                   @PathVariable Conference conference,
                                   @RequestParam("id") Presentation presentation,
                                   @RequestParam("theme") String theme) {
        presentationService.addOrUpdate(currentUser, presentation, theme, conference);
        return "redirect:/welcome";
    }
    @GetMapping("/all")
    public String myPresentations(@AuthenticationPrincipal User currentUser,
                               Model model) {
        model.addAttribute("presentations", presentationService.findByUser(currentUser));
        return "presentationEdit";
    }
}
