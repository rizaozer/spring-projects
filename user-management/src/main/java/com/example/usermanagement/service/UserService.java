package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.entity.UserSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.usermanagement.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService  {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.insertUser(user);
    }

    public List<User> getUsers() {
        return userRepository.selectAllUsers();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.selectUserByUsername(username);
    }

    public List<User> search(UserSearchParam by, String value) {
        by.equals(UserSearchParam.LAST_NAME.toString());
        return userRepository.search(by, value);
    }

}
