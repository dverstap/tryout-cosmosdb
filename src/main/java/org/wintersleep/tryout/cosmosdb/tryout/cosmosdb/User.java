package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Container(containerName = "user")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    private String id;

    private String name;

    @CreatedDate
    private Instant createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Instant updatedAt;

    @LastModifiedBy
    private String updatedBy;

}
