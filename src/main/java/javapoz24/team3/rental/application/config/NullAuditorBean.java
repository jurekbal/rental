package javapoz24.team3.rental.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/*
Ta konfiguracja 'AuditorAware' jest potrzebna żeby działa adnotacja @DateCreated w encji Booking
 */

@Configuration
@EnableJpaAuditing
public class NullAuditorBean implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        return Optional.empty();
    }
}
