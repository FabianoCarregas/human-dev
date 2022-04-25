package br.com.alura.humandev.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    List<User> users = new ArrayList<>();

    @Override
    public String getAuthority() {
        return this.name;
    }
}
