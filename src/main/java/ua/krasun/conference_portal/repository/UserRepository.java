package ua.krasun.conference_portal.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.krasun.conference_portal.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    Optional<User> findByEmail(String email);

    List<User> findAll(Sort sort);
}
