package com.eustache.auto_trader.Entity;

import java.util.UUID;

import com.eustache.auto_trader.Helpers.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(
    name = "User"
)
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = {"email"}
        )
    }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name", nullable = false, length = 100)
    private String  firstName;
    @Column(name = "last_name", nullable = false, length = 100)
    private String  lastName;
    @Column(name = "email", nullable = false, length = 100)
    private String  email;
    @Column(name = "password", nullable = false)
    private String  password;
    @Column(name = "phone_number", nullable = false)
    private String  phoneNumber;
    @Column(name = "role", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private Role role;

    // Relationships
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;
}
