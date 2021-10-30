package org.launchcode.dndproject.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max=30, message= "Username must be between 3 and 30 characters")
    private String username;

//    @NotNull
//    @NotBlank
//    @Size(min = 3, max=30, message= "Username must be between 3 and 30 characters")
    private String userEmail;

    @NotNull
    @NotBlank
    @Size(min= 8, max = 30, message="Password must be between 8 and 30 characters")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}