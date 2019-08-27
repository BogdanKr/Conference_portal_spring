package ua.krasun.conference_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.krasun.conference_portal.entity.RoleType;
import ua.krasun.conference_portal.entity.User;
import ua.krasun.conference_portal.repository.UserRepository;

import java.util.Arrays;
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
        if (user.isActive()) user.setRoleType(RoleType.SPEAKER);
        else user.setRoleType(RoleType.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<User> findByName(String findName) {
        boolean isPresent = Optional.ofNullable(findName).isPresent();
        if (isPresent && !findName.isEmpty()) return userRepository.findByFirstName(findName);
        else return userRepository.findAll();
    }

    public List<RoleType> roleTypeList() {
        return Arrays.asList(RoleType.values());
    }

    public void userEdit(String firstName,
                         String email,
                         String password,
                         boolean active,
                         String roleType,
                         User user) {
        user.setFirstName(firstName);
        user.setEmail(email);
        if (!password.isEmpty()) user.setPassword(passwordEncoder.encode(password));
        boolean isRoleTypePresent = Optional.ofNullable(roleType).isPresent();
        if (isRoleTypePresent) {
            user.setActive(active);
            switch (roleType) {
                case "USER":
                    user.setRoleType(RoleType.USER);
                    break;
                case "ADMIN":
                    user.setRoleType(RoleType.ADMIN);
                    break;
                case "SPEAKER":
                    user.setRoleType(RoleType.SPEAKER);
                    break;
            }
        }
        userRepository.save(user);
    }

    public List<User> sortByName(String param){
        return userRepository.findAll(new Sort(param));
    }
}
