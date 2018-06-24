package me.aikin.bicyclestore.bicycle.security.jwt;


import me.aikin.bicyclestore.bicycle.security.principal.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    boolean validateToken(HttpServletRequest request);

    UserPrincipal getAuthorizedCurrentUser(HttpServletRequest request);
}
