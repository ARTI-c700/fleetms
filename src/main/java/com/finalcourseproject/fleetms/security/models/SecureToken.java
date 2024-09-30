package com.finalcourseproject.fleetms.security.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.sql.Timestamp;

@Entity
@Table(name = "secure_tokens")
public class SecureToken {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(unique = true)
    private String token;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp timestamp;

    @Setter
    @Getter
    @Column(updatable = false)
    @Basic(optional = false)
    private LocalDateTime expireAt;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Transient
    private boolean isExpired;

    public Timestamp getTimeStamp() {
        return timestamp;
    }

    public boolean isExpired() {

        return getExpireAt().isBefore(LocalDateTime.now()); // this is generic implementation, you can always make it timezone specific
    }

}
