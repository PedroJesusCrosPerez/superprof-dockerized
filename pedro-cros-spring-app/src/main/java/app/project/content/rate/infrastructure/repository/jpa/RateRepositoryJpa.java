package app.project.content.rate.infrastructure.repository.jpa;

import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepositoryJpa extends JpaRepository<RateJpa, Long> {
}
