package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DevDataInstaller implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        String name = "user-1";
        if (userRepository.findByName(name).isPresent()) {
            log.info("User {} already exists.", name);
        } else {
            User test = User.builder()
                    .name(name)
                    .build();
            User saved = userRepository.save(test);
            log.info("Saved user: {}", saved);
        }
    }

}
