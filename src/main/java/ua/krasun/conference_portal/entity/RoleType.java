package ua.krasun.conference_portal.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType  implements GrantedAuthority {
    ADMIN,
    USER,
    SPEAKER;

    @Override
    public String getAuthority() {
        return name();
    }
}
