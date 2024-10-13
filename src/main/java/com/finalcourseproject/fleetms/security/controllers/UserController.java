//package com.finalcourseproject.fleetms.security.controllers;
//
//import com.finalcourseproject.fleetms.exception.UserAlreadyExistException;
//import com.finalcourseproject.fleetms.security.models.User;
//import com.finalcourseproject.fleetms.security.services.RoleService;
//import com.finalcourseproject.fleetms.security.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Optional;
//
//@Controller
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    private final RoleService roleService;
//
//    private final MessageSource messageSource;
//
//    @GetMapping("/security/users")
//    public String getAll(Model model) {
//        model.addAttribute("users", userService.findAllUsers());
//        return "/security/users";
//    }
//
//    @GetMapping("/security/user/{op}/{id}")
//    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
//        Optional<User> user = userService.findUser(id);
//        model.addAttribute("user", user);
//        model.addAttribute("userRoles", roleService.getUserRoles(id));
//        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
//        return "/security/user" + op; //returns employeeEdit or employeeDetails
//    }
//
//    @PostMapping("/usersAddNew")
//    public String addNew(User user, Model model) throws UserAlreadyExistException {
//        userService.register(user);
////        RedirectView redirectView = new RedirectView("/login", true);
//        model.addAttribute("registrationSuccess",
//                "You can check your email to complete your registration");
//        return "security/registrationSuccessful";
//    }
//
//}
