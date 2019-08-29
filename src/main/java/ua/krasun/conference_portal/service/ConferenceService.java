package ua.krasun.conference_portal.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.entity.dto.ConferenceDto;
import ua.krasun.conference_portal.repository.ConferenceRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConferenceService {
    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<ConferenceDto> findAll(User currentUser) {
        return conferenceRepository.findAllAndSort(currentUser, new Sort("date"));
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
}
