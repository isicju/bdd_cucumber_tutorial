package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceOldFashionTest {

    private UserService userService;

    @Before
    public void init(){
        userService = new UserService();
    }

    @Test
    public void userCreatedSuccessfully() {
        User actual = userService.createUser(new User("John", 12));
        assertEquals(actual, userService.getUser("John"));
    }

    @Test(expected = RuntimeException.class)
    public void existentUserError() {
        userService.createUser(new User("John", 12));
        userService.createUser(new User("John", 16));
    }

    @Test(expected = RuntimeException.class)
    public void tooShortNameError() {
        userService.createUser(new User("ab", 45));
    }

}
