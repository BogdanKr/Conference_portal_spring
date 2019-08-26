package ua.krasun.conference_portal.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType  implements GrantedAuthority {
    ADMIN,
    SPEAKER,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
