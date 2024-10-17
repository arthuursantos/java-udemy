package com.javaudemy.project.config;

import com.javaudemy.project.entities.User;
import com.javaudemy.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Arthur Santos", "arthur@gmail.com", "19999344489", "vaicorinthians");
        User u2 = new User("João Felipe", "joao@yahoo.com", "19998764532", "mortis1000");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
