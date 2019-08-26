package ua.krasun.conference_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.RoleType;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.repository.UserRepository;

@Service
public class RegFormService {
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    public boolean regUser(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        if (user.isActive()) user.setRoleType(RoleType.SPEAKER);
        else user.setRoleType(RoleType.USER);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return true;
    }
}

