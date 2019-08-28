package ua.krasun.conference_portal.entity.dto;

import lombok.Getter;
import lombok.ToString;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.Presentation;
import ua.krasun.conference_portal.entity.User;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
public class ConferenceDto {
    private Long id;
    private LocalDate date;
    private String subject;
    private User author;
    private List<Presentation> presentations;
    private Long registrations;
    private boolean meRegistered;

    public ConferenceDto(Conference conference, Long registrations, boolean meRegistered) {
        this.id = conference.getId();
        this.date = conference.getDate();
        this.subject = conference.getSubject();
        this.author = conference.getAuthor();
        this.presentations = conference.getPresentations();
        this.registrations = registrations;
        this.meRegistered = meRegistered;
    }
}
