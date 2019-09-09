package ua.krasun.conference_portal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.entity.dto.ConferenceDto;
import ua.krasun.conference_portal.repository.ConferenceRepository;

import java.time.LocalDate;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Page<ConferenceDto> findAll(User currentUser, Pageable pageable) {
        return conferenceRepository.findAll(currentUser, pageable);
    }

    public void addConference(LocalDate date, String subject, User currentUser) {
        Conference conference = Conference.builder()
                .date(date)
                .subject(subject)
                .author(currentUser)
                .build();
        conferenceRepository.save(conference);
    }

    public void updateConference(Conference conference, LocalDate date, String subject) {
        if (conference.getDate().equals(date) && conference.getSubject().equals(subject)) return;
        conference.setDate(date);
        conference.setSubject(subject);
        conferenceRepository.save(conference);
    }

    public void registration(User currentUser, Conference conference) {
        if (conference.getRegistrations().contains(currentUser)) {
            conference.getRegistrations().remove(currentUser);
        } else {
            conference.getRegistrations().add(currentUser);
        }
        conferenceRepository.save(conference);
    }

    public Page<ConferenceDto> findUserRegistrations(User currentUser, Pageable pageable) {
        return conferenceRepository.findRegisteredTrue(currentUser, pageable);
    }
}
