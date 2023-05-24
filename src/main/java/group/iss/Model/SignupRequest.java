package group.iss.Model;

import java.util.Set;

public class SignupRequest {
    private java.lang.String email;
    private java.lang.String password;
    private java.lang.String username;

    private Set<String> role;

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> roles) {
        this.role = roles;
    }

    public SignupRequest(java.lang.String email, java.lang.String password, java.lang.String username, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = roles;
    }
}
