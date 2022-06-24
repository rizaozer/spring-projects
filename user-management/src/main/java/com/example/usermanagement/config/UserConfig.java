package com.example.usermanagement.config;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public void setUsersMap() {
        UserRepository.usersMap.put("user1", new User("rizaozer", "riza123", "Riza", "Ozer"));
        UserRepository.usersMap.put("user2", new User("aligunes", "ali123", "Ali", "Gunes"));
    }
}
