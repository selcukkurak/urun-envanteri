package tr.gov.tuik.urunenvanteri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import tr.gov.tuik.jwt.security.UserPrincipal;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditAwareImpl();
    }

    public class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {

        @Override
        public Optional<Long> getCurrentAuditor() {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
                return Optional.empty();
            }

            UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

            return Optional.ofNullable(principal.getId());
        }
    }
}
