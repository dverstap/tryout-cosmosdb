package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import com.azure.spring.data.cosmos.core.mapping.EnableCosmosAuditing;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCosmosRepositories
@EnableCosmosAuditing
public class TryoutCosmosdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryoutCosmosdbApplication.class, args);
    }

}
