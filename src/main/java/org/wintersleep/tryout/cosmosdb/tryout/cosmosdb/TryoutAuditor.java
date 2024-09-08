package org.wintersleep.tryout.cosmosdb.tryout.cosmosdb;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TryoutAuditor implements AuditorAware<String> {

    private static final Optional<String> SYSTEM = Optional.of("system");
    private static final Optional<String> ANONYMOUS = Optional.of("anonymous");

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return SYSTEM;
        }
        if (authentication instanceof AnonymousAuthenticationToken) {
            return ANONYMOUS;
        }
        String principalName = authentication.getName();
        if (principalName == null) {
            return SYSTEM;
        }
        return Optional.of(principalName);
    }

}
