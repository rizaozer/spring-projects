package com.example.usermanagement.repository;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.entity.UserSearchParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    public static Map<String, User> usersMap = new HashMap<>();

    public void insertUser(User user) {
        usersMap.put(user.getUsername(), user);
    }

    public List<User> selectAllUsers() {
        return new ArrayList<>(usersMap.values());
    }

    public Optional<User> selectUserByUsername(String username) {
        return usersMap.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public List<User> search(UserSearchParam by, String value) {
        if(by == null) {
            return Collections.emptyList();
        }
        return usersMap.values().stream()
                .filter(user -> StringUtils
                        .equalsIgnoreCase(getParamValue(user, by), value))
                        .collect(Collectors.toList());
    }

    public String getParamValue(User user, UserSearchParam param) {
        return switch(param) {
            case USERNAME -> user.getUsername();
            case FIRST_NAME -> user.getFirstName();
            case LAST_NAME -> user.getLastName();
        };
    }

    public void addDefaultUsers() {
        usersMap.put("rizaozer", new User("rizaozer", "riza123", "Riza", "Ozer"));
    }
}
