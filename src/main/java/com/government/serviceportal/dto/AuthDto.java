package com.government.serviceportal.dto;

public class AuthDto {

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class RegisterRequest {
        private String email;
        private String password;
        private String fullName;
        private String role;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }

    public static class JwtResponse {
        private String token;
        private String type = "Bearer";
        private String email;
        private String role;

        public JwtResponse(String token, String email, String role) {
            this.token = token;
            this.email = email;
            this.role = role;
        }

        public String getToken() { return token; }
        public String getType() { return type; }
        public String getEmail() { return email; }
        public String getRole() { return role; }
    }
}