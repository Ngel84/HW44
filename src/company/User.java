package company;

import company.Annotations.DisplayName;
import company.Annotations.Validators.Email;
import company.Annotations.Validators.Length;
import company.Annotations.Validators.NotBlank;

import java.io.Serializable;

public class User implements Serializable {

    @NotBlank
    @Length (minLength = 1)
    @DisplayName(printValue="User name")
    private String userName;

    @NotBlank
    @Length
    @DisplayName(printValue = "Password")
    transient private String password;

    @NotBlank
    @Length
    @DisplayName(printValue = "ID")
    transient private String id;

    @NotBlank
    @Length
    @DisplayName(printValue = "First name")
    private String fistName;

    @NotBlank
    @Length
    @DisplayName(printValue = "Last name")
    private String lastName;

    @Email
    @NotBlank
    @Length
    @DisplayName(printValue = "E-mail")
    private String email;

    @DisplayName(printValue = "City")
    private String city;

    @DisplayName(printValue = "Address")
    private String address;

    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }


}


