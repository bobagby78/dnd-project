package org.launchcode.dndproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity{

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull(message="You must have a username to continue")
    private String username;

    private String pwordHash;

    @NotNull (message="Please enter a valid Email address")
    private String userEmail;

    public User(){
    }

    public User(String username, String password, String userEmail) {
        this.username = username;
        this.pwordHash = encoder.encode(password);
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwordHash);
    }

}
