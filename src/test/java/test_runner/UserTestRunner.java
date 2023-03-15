package test_runner;

import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class UserTestRunner extends Setup {
    User user;

    @Test(priority = 1, description = "Do login with invalid email")
    public void doLoginWithInvalidEmail() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithInvalidEmail();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 2, description = "Do login with invalid email")
    public void doLoginWithInvalidPassword() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithInvalidPassword();
        Assert.assertTrue(user.getMessage().contains("Password incorrect"));
    }

    @Test(priority = 3, description = "Do login with invalid credential")
    public void doLoginWithInvalidCreds() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithInvalidCred();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 4, description = "Do login with valid credential")
    public void doLoginWithValidCreds() throws IOException, ConfigurationException {
        user = new User();
        user.callLoginAPIWithValidCreds();
        Assert.assertTrue(user.getMessage().contains("Login successfully"));
    }


    @Test(priority = 5, description = "Create user with valid information")
    public void createNewUser() throws IOException, ConfigurationException {
        user = new User();
        user.createNewUser();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }

    @Test(priority = 6, description = "Create user with existing information")
    public void createExistingUser() throws IOException {
        user = new User();
        user.createUserExistingInfo();
        Assert.assertTrue(user.getMessage().contains("User already exists"));
    }

    @Test(priority = 7, description = "Create Agent with valid information")
    public void createNewAgent() throws IOException, ConfigurationException {
        user = new User();
        user.createAgent();
        Assert.assertTrue(user.getMessage().contains("User created"));
    }

    @Test(priority = 8)
    public void seachUserByInvalidPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserByInvalidPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User not found"));
    }

    @Test(priority = 9)
    public void seachUserByPhoneNumber() throws IOException, ConfigurationException {
        user = new User();
        user.searchUserByPhonenumber();
        Assert.assertTrue(user.getMessage().contains("User found"));
    }
}
