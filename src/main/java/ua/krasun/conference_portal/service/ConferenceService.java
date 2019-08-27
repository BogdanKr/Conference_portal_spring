package ua.krasun.conference_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.Conference;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.repository.ConferenceRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConferenceService {
    @Autowired
    ConferenceRepository conferenceRepository;

   public  List<Conference> findAll(){
       return conferenceRepository.findAll();
   }

   public void addConference(LocalDate date, String subject, User currentUser){
       Conference conference = new Conference(date.plusDays(1), subject, currentUser);
       conferenceRepository.save(conference);
   }

    public void updateConference(Conference conference, LocalDate date, String subject) {
       conference.setDate(date.plusDays(1));
       conference.setSubject(subject);
       conferenceRepository.save(conference);
    }
}
