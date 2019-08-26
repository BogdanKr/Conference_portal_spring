package ua.krasun.conference_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.RoleType;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("Wrong input!!"));
    }

    public boolean regUser(User user) {
        boolean isPresent = Optional.ofNullable(userRepository.findByEmail(user.getEmail())).isPresent();
        if (!isPresent) {
            if (user.isActive()) user.setRoleType(RoleType.SPEAKER);
            else user.setRoleType(RoleType.USER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setActive(true);
            userRepository.save(user);
            return true;
        } else return false;

    }

    public List<User> findByName(String findName) {
        return Optional.of(userRepository.findByFirstName(findName)).orElse(userRepository.findAll());
    }

}
