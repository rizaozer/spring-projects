package com.example.usermanagement.javax;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.entity.UserSearchParam;
import org.springframework.web.bind.annotation.*;
import com.example.usermanagement.service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("username")
    public Optional<User> getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    // localhost:8080/users/search?by={username/first_name/last_name}&value=Riza
    @GetMapping("search")
    public List<User> searchUsers(@RequestParam UserSearchParam by,
                                  @RequestParam String value) {
        return userService.search(by, value);
    }

}
