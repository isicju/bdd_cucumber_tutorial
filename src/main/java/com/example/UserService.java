package com.example;


import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users;

    public UserService(){
        users = new HashMap<>();
    }

    public User createUser(User user){
        if(users.get(user.getName()) != null) throw new RuntimeException("User Exist!");
        users.put(user.getName(), user);
        return user;
    }

    public User getUser(String user){
        return users.get(user);
    }

}
