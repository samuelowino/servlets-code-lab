package org.apluscreators.servletlabs.model;

public class User {

    private String uuid;
    private String username;
    private String password;

    public User() {
    }

    public User(String uuid, String username, String password) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
