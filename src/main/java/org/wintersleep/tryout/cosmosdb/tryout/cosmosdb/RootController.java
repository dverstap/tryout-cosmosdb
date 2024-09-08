package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import com.azure.cosmos.implementation.guava25.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {

    private final UserRepository userRepository;

    @GetMapping //("/")
    public List<User> users() {
        List<User> result = ImmutableList.copyOf(userRepository.findAll());
        log.info("Users: {}", result);
        return result;
    }

    //@PostMapping
    @GetMapping("/create") // hack
    public User createUser(@RequestParam String name) {
        return userRepository.save(User.builder().name(name).build());
    }

}
