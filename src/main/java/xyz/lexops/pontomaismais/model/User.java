package xyz.lexops.pontomaismais.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(String password, String email, String name, Long id, String role) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.id = id;
        this.role = Role.fromCode(role);
    }

    public void setRole(String role) {
        this.role = Role.fromCode(role);
    }
}
