package ua.krasun.conference_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.krasun.conference_portal.entity.Presentation;
import ua.krasun.conference_portal.entity.User;

import java.util.List;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    @Query("from Presentation p where p.author = :author")
    List<Presentation> finByUser(@Param("author") User author);
}
