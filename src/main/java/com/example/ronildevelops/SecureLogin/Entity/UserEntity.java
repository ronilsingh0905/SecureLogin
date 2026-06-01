package com.example.ronildevelops.SecureLogin.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ROLE role;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks = new ArrayList<>();
}
