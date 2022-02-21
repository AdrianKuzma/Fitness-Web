package sk.fitness.fitnessweb.dto;

import com.sun.istack.NotNull;

public class RegisterDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    public RegisterDto(@NotNull String username, @NotNull String password, @NotNull String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
