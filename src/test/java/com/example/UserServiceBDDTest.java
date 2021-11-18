package com.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceBDDTest {

    private UserService userService;

    @Given("^Create user API is provided$")
    public void initializeUserService() {
        userService = new UserService();
    }

    @When("^Creating user (\\w+) with age (\\d+) calling user API$")
    public void createUser(String name, int age) {
        userService.createUser(new User(name, age));
    }

    @Then("^User Api returns (\\w+) user with (\\d+) age$")
    public void validateUserByName(String name, int age) {
        User userFromApi = userService.getUser(name);
        Assert.assertEquals(name, userFromApi.getName());
        Assert.assertEquals(age, userFromApi.getAge());
    }

    @Then("^Fail to create user (\\w+) with age (\\d+) when calling user API$")
    public void failUserCreation(String name, int age) {
        assertThrows(RuntimeException.class, () -> userService.createUser(new User(name, age)), "Should fail");
    }

    @When("^Creating multiple users$")
    public void creatingMultipleUsers(List<User> users) {
        users.forEach(user -> assertNotNull(userService.createUser(user)));
    }

    @Then("^All created users now available from user API$")
    public void createUser(List<User> users) {
        users.forEach(user -> containsInAnyOrder(users, userService.getUser(user.getName())));
    }

}
