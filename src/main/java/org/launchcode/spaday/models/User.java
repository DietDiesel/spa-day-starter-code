package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Username is blank")
    @NotNull(message = "Username is null")
    @NotEmpty(message = "Username is empty")
    @Size(min = 5, max = 15, message = "Please use a username between 5 and 15 characters")
    private String username;

    @Email(message = "Please use a correct email address, with @ and domain")
    private String email;

    @NotBlank(message = "Password is blank")
    @NotNull(message = "Password is null")
    @NotEmpty(message = "Password is empty")
    @Size(min = 6, message = "Password too short")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (!password.equals(null) && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
