package ua.krasun.conference_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.Presentation;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.repository.PresentationRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PresentationService {
    @Autowired
    PresentationRepository presentationRepository;

    public void addOrUpdate(User currentUser, Presentation presentation, String theme, Conference conference) {
        boolean isPresentationPresent = Optional.ofNullable(presentation).isPresent();
        if (!isPresentationPresent) {
            presentation = new Presentation(theme, currentUser, conference);
            presentationRepository.save(presentation);
        } else {
            presentation.setTheme(theme);
            presentationRepository.save(presentation);
        }
    }

    public List<Presentation> findAll() {
        List<Presentation> presentationList = presentationRepository.findAll();
        presentationList.sort((o1, o2) -> o1.getConference().getDate().compareTo(o2.getConference().getDate()));
        return presentationList;
    }


    public List<Presentation> findByUser(User user) {
        if (user.isAdmin()) return findAll();
        else return presentationRepository.findAll().stream()
                .filter(presentation -> presentation.getAuthor().equals(user))
                .collect(Collectors.toList());
    }

}
