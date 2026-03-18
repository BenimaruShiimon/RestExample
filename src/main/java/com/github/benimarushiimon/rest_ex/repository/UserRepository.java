package com.github.benimarushiimon.rest_ex.repository;

import com.github.benimarushiimon.rest_ex.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("admin") || password.equals("admin")) {
            return List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE);
        } else if (user.equals("user") || password.equals("user")) {
            return List.of(Authorities.READ, Authorities.WRITE);
        }
        return Collections.emptyList();
    }
}
