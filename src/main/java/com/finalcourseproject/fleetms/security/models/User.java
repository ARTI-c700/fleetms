package com.finalcourseproject.fleetms.security.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "\"User\"")
public class User extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private boolean accountVerified;
    private boolean loginDisabled;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;
}
