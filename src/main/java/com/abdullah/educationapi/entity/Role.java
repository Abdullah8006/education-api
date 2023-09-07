package com.abdullah.educationapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
