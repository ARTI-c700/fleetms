//package com.finalcourseproject.fleetms.security.services;
//
//import com.finalcourseproject.fleetms.security.models.SecureToken;
//import com.finalcourseproject.fleetms.security.repositories.SecureTokenRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.keygen.BytesKeyGenerator;
//import org.springframework.security.crypto.keygen.KeyGenerators;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Base64;
//
//@Service
//@RequiredArgsConstructor
//public class DefaultSecureTokenService implements SecureTokenService{
//
//    private final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(12);
//    private final SecureTokenRepository secureTokenRepository;
//
//    @Value("2800")
//    private int tokenValidityInSeconds;
//
//    @Override
//    public SecureToken createToken() {
//        String tokenValue = new String(Base64.getEncoder().encode(DEFAULT_TOKEN_GENERATOR.generateKey()));
//        SecureToken secureToken = new SecureToken();
//        secureToken.setToken(tokenValue);
//        secureToken.setExpireAt(LocalDateTime.now().plusSeconds(tokenValidityInSeconds));
//        this.saveSecureToken(secureToken);
//        return secureToken;
//    }
//
//    @Override
//    public void saveSecureToken(SecureToken secureToken) {
//        secureTokenRepository.save(secureToken);
//    }
//
//    @Override
//    public SecureToken findByToken(String token) {
//        return secureTokenRepository.findByToken(token);
//    }
//
//    @Override
//    public void removeToken(SecureToken secureToken) {
//        secureTokenRepository.delete(secureToken);
//    }
//}
