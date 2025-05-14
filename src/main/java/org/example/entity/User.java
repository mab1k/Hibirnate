package org.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;
    @Column(name = "emails", nullable = false)
    @ColumnDefault("123")
    String email;

}
