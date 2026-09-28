package com.xworkz.airapp.aircraft;

public class Password {

    private String username;
    private String password;
    private int attempts;

    public void checkStrength() {
        if (password.length() >= 8) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }
    }

    @Override
    public String toString() {
        return "Password{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", attempts=" + attempts +
                '}';
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

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
