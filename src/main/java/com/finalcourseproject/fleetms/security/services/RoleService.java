//package com.finalcourseproject.fleetms.security.services;
//
//import com.finalcourseproject.fleetms.security.models.Role;
//import com.finalcourseproject.fleetms.security.models.User;
//import com.finalcourseproject.fleetms.security.repositories.RoleRepository;
//import com.finalcourseproject.fleetms.security.repositories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class RoleService {
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//
//    private User fetchVerifiedUser(Integer userId) {
//        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
//    }
//
//    // Get All Roles
//    public List<Role> findAllRoles() {
//        return roleRepository.findAll();
//    }
//
//    // Get The Role By id
//    public Role getRole(Integer id) {
//        return roleRepository.findById(id).orElse(null);
//    }
//
//    // Delete The Role
//    public void deleteRole(Integer id) {
//        roleRepository.deleteById(id);
//    }
//
//    // Save A Role
//    public void saveRole(Role role) {
//        roleRepository.save(role);
//    }
//
//    // Assign Role To The User
//    public void assignRoleToUser(Integer userId, Integer roleId) {
//        User user = fetchVerifiedUser(userId);
//        Role role = roleRepository.findById(roleId).orElse(null);
//        Set<Role> userRoles = user.getRoles();
//
//        userRoles.add(role);
//        user.setRoles(userRoles);
//        userRepository.save(user);
//    }
//
//    // Unassign Role To The User
//    public void unassignRoleToUser(Integer userId, Integer roleId) {
//        User user = fetchVerifiedUser(userId);
//        assert user != null;
//        Set<Role> userRoles = user.getRoles();
//
//        userRoles.removeIf(x -> Objects.equals(x.getId(), roleId));
//        userRepository.save(user);
//    }
//
//    // Get The User Roles
//    public Set<Role> getUserRoles(Integer userId) {
//        return fetchVerifiedUser(userId).getRoles();
//    }
//
//    // Does The User Has A Selected Role
//    public boolean isUserInRole(Integer userId, String roleName) {
//        User user = fetchVerifiedUser(userId);
//        Set<Role> userRoles = user.getRoles();
//        return userRoles
//                .stream()
//                .anyMatch(role -> role.getDescription().equals(roleName));
//    }
//
//    //
//    public List<Role> getUserNotRoles(Optional<User> user) {
//        return roleRepository.getUserNotRoles(user.map(User::getId).orElse(null));
//    }
//}
