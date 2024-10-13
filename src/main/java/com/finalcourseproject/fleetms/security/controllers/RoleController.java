//package com.finalcourseproject.fleetms.security.controllers;
//
//import com.finalcourseproject.fleetms.security.models.Role;
//import com.finalcourseproject.fleetms.security.services.RoleService;
//import com.finalcourseproject.fleetms.security.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class RoleController {
//    private final RoleService roleService;
//    private final UserService userService;
//
//    @GetMapping("/security/roles")
//    public String parameters(Model model) {
//        List<Role> roles = roleService.findAllRoles();
//        model.addAttribute("roles", roles);
//        return "security/roles";
//    }
//
//    @GetMapping("/security/role/{id}")
//    @ResponseBody
//    public Role getById(@PathVariable Integer id) {
//        return roleService.getRole(id);
//    }
//
//    @PostMapping("/security/roles")
//    public String save(Role role) {
//        roleService.saveRole(role);
//        return "redirect:/security/roles";
//    }
//
//    @DeleteMapping(value = "/security/role/delete/{id}")
//    public String delete(@PathVariable Integer id) {
//        roleService.deleteRole(id);
//        return "redirect:/security/roles";
//    }
//
//    @RequestMapping("/security/role/assign/{userId}/{roleId}")
//    public String assignRole(@PathVariable Integer userId,
//                             @PathVariable Integer roleId) {
//        roleService.assignRoleToUser(userId, roleId);
//        return "redirect:/security/user/Edit/" + userId;
//    }
//
//    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
//    public String unassignRole(@PathVariable Integer userId,
//                               @PathVariable Integer roleId) {
//        roleService.unassignRoleToUser(userId, roleId);
//        return "redirect:/security/user/Edit/" + userId;
//    }
//}
