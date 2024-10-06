package app.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "username")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_name", referencedColumnName = "name")
            })
    Set<Role> roles = new HashSet<>();


    public User(String username, String password) {
        this.username = username;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt()); // hashet password
    }

    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password); // sammenligner password med hashet password
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
}
