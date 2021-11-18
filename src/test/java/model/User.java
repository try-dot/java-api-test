package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private Long id;
    @JsonProperty("username")
    private String userName;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String phone;
    private long userStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("username")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(long userStatus) {
        this.userStatus = userStatus;
    }

}
