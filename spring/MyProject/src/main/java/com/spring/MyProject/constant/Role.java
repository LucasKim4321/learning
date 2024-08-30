package com.spring.MyProject.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Getter
public enum Role {

    USER, ADMIN; // 0,1

//    USER, ADMIN  문제가 있음. 이렇게 쓰면 @Secured(value="ADMIN") authorize ="hasAnyAuthority('USER')"는 되는데
//    @PreAuthorize("hasAnyRole('ADMIN')") @PreAuthorize("hasAnyRole('ROLE_ADMIN')")는 안먹힘

    // 2.
//    USER(Authority.USER), ADMIN(Authority.ADMIN);
//
//    private final String authority;
//
//    Role(String authority) {
//        this.authority = authority;
//    }
//    public String getAuthority() {
//        return this.authority;
//    }
//
//    public static class Authority {
//        public static final String USER = "USER";
//        public static final String ADMIN = "ADMIN";
//    }


}

/*
@Getter
@RequiredArgsConstructor
public enum Role {
    USER ("ROLE_USER"),
    EMPLOYER("ROLE_EMPLOYER,ROLE_USER"),
    ADMIN ("ROLE_ADMIN,ROLE_EMPLOYER,ROLE_USER"),
    TEMP_EMPLOYER("ROLE_TEMPORARY_EMPLOYER"),
    TEMP_USER ("ROLE_TEMPORARY_USER"),
    OAUTH_FIRST_JOIN ("ROLE_FIRST_JOIN_OAUTH_USER");

    private final String roles;
    public static String getIncludingRoles(String role){
        return Role.valueOf(role).getRoles();
    }
    public static String addRole(Role role, String addRole){
        String priorRoles = role.getRoles();
        priorRoles += ","+addRole;
        return priorRoles;
    }
    public static String addRole(String roles, Role role){
        return roles + "," + role.getRoles();

    }
}
*/