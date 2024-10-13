package com.finalcourseproject.fleetms.security.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "secure_tokens")
public class SecureToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(unique = true)
    private String token;

    @Setter
    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public boolean isExpired() {
        return getExpireAt().isBefore(LocalDateTime.now()); // this is generic implementation, you can always make it timezone specific
    }

}
