package me.aikin.bicyclestore.bicycle.security.jwt;

public interface JwtTokenRepository {
    String extractAuthorizedPayload(String jwtToken);

    boolean validateToken(String jwtToken);
}
