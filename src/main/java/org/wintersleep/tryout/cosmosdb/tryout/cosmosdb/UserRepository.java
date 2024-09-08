package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CosmosRepository<User, String>/*, ListCrudRepository<User, String>*/ {

    // Just declaring the methods that return Iterable<User> as List<User>
    // (for instance by extends ListCrudRepository<User, String>) does not work:
    // You really have to iterate through the iterable:
//    @Override
//    List findAll();

    Optional<User> findByName(String name);

}
