package ua.krasun.conference_portal.controller;

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
    private final PresentationService presentationService;

    public PresentationController(PresentationService presentationService) {
        this.presentationService = presentationService;
    }

    @GetMapping("/{conference}")
    public String presentationEditForm(@PathVariable Conference conference,
                               Model model,
                               @RequestParam(required = false) Presentation presentation) {
        model.addAttribute("presentation", presentation);
        model.addAttribute("conference", conference);
        model.addAttribute("presentations", presentationService.findAll());
        return "presentationEdit";
    }

    @PostMapping("/{conference}")
    public String updatePresentation(@AuthenticationPrincipal User currentUser,
                                   @PathVariable Conference conference,
                                   @RequestParam("id") Presentation presentation,
                                   @RequestParam("theme") String theme) {
        presentationService.addOrUpdate(currentUser, presentation, theme, conference);
        return "redirect:/welcome";
    }

    @GetMapping("/all_my")
    public String myPresentations(@AuthenticationPrincipal User currentUser,
                               Model model) {
        model.addAttribute("presentations", presentationService.findByUser(currentUser));
        return "presentationEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('SPEAKER')||hasAuthority('USER')")
    @GetMapping("/")
    public String allPresentations(Model model) {
        model.addAttribute("presentations", presentationService.findAll());
        return "presentationEdit";
    }

    @GetMapping("/delete/{presentation}")
    public String presentationEditForm(@PathVariable Presentation presentation,
                                       Model model){
        presentationService.deletePresentation(presentation);
        model.addAttribute("presentations", presentationService.findAll());
        return "presentationEdit";
    }

}
