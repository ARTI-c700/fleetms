package com.finalcourseproject.fleetms.security.services;

import com.finalcourseproject.fleetms.exception.InvalidTokenException;
import com.finalcourseproject.fleetms.exception.UserAlreadyExistException;
import com.finalcourseproject.fleetms.mailing.AccountVerificationEmailContext;
import com.finalcourseproject.fleetms.mailing.EmailService;
import com.finalcourseproject.fleetms.security.models.SecureToken;
import com.finalcourseproject.fleetms.security.models.User;
import com.finalcourseproject.fleetms.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${site.base.url.https")
    private String baseUrl;

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final SecureTokenService secureTokenService;
    private final EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Get All Users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Get User
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);
    }

    // Delete A User
    public void removeUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Update The User
    public void register(User user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("This user already exist");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        sendRegistrationConfirmationEmail(user);
    }


    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public void sendRegistrationConfirmationEmail(User user) {
        SecureToken secureToken = secureTokenService.createToken();
        secureToken.setUser(user);
        secureTokenService.saveSecureToken(secureToken);

        AccountVerificationEmailContext context = new AccountVerificationEmailContext();
        context.init(user);
        context.setToken(secureToken.getToken());
        context.buildVerificationUrl(baseUrl, secureToken.getToken());

        try {
            emailService.sendMail(context);
        } catch (MessagingException e) {
            logger.error("Failed to send registration " +
                         "confirmation email to user: {}", user.getEmail(), e);
        }
    }

    public boolean verifyUser(String token) throws InvalidTokenException {
        SecureToken secureToken = secureTokenService.findByToken(token);
        boolean isTokenNull = Objects.isNull(secureToken);
        boolean isTokenExpired = secureToken.isExpired();
        boolean isTokenTextValid = StringUtils.hasText(token) && token.equals(secureToken.getToken());

        if(isTokenNull || isTokenExpired || isTokenTextValid) {
            String errorMessage = "Token is not valid: "
                                    + (isTokenNull ? "Token is null" : "")
                                    + (isTokenExpired ? "Token is expired" : "")
                                    + (isTokenTextValid ? "Token is not valid" : "");
            logger.error(errorMessage);

            throw new InvalidTokenException(errorMessage);
        }

        User user = userRepository.findByEmail(secureToken.getUser().getEmail());
        if (Objects.isNull(user)) return false;

        user.setAccountVerified(true);
        userRepository.save(user);

        secureTokenService.removeToken(secureToken);
        return true;
    }
}
