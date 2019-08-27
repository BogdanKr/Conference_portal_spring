package ua.krasun.conference_portal.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.krasun.conference_portal.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    User findByEmail(String email);

    List<User> findAll(Sort sort);
}
