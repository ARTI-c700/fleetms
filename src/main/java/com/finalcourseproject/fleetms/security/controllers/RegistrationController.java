package com.finalcourseproject.fleetms.security.controllers;

import com.finalcourseproject.fleetms.exception.InvalidTokenException;
import com.finalcourseproject.fleetms.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private static final String REDIRECT_LOGIN = "redirect:/login";
    private final UserService userService;
    private final MessageSource messageSource;

    @GetMapping("/verify")
    public String verifyUser(@RequestParam String token, RedirectAttributes redirectAttributes) {
        if (StringUtils.isEmpty(token)) {
            redirectAttributes.addFlashAttribute("tokenError", "Token is invalid");
            return REDIRECT_LOGIN;
        }
        try {
            userService.verifyUser(token);
        } catch (InvalidTokenException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("tokenError", "Token is invlid");
            return REDIRECT_LOGIN;
        }

        redirectAttributes.addFlashAttribute("message",
                messageSource.getMessage("verification.email.msg", null, LocaleContextHolder.getLocale()));
        return REDIRECT_LOGIN;
    }
}
