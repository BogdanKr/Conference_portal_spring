package ua.krasun.conference_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.krasun.conference_portal.entity.Presentation;

import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

}
