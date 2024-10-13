package com.finalcourseproject.fleetms.mailing;


import com.finalcourseproject.fleetms.security.models.User;
import org.springframework.web.util.UriComponentsBuilder;

public class AccountVerificationEmailContext extends AbstractEmailContext {

    @Override
    public <T> void init(T context) {
        User user = (User) context;
        put("firstName", user.getFirstname());
        setTemplateLocation("mailing/email-verification");
        setSubject("Complete your registration");
        setFrom("no-reply@kttpro.com");
        setTo(user.getEmail());
    }

    public void setToken(String token) {
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token) {
        final String url = UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/register/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}