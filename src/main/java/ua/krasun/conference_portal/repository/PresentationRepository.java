package ua.krasun.conference_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.krasun.conference_portal.entity.Presentation;
import ua.krasun.conference_portal.entity.User;

import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    List<Presentation> findByAuthor(User author);
}