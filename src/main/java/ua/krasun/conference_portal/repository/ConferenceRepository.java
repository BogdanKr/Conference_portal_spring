package ua.krasun.conference_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.krasun.conference_portal.entity.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
