package app.project.content.pack.infrastructure.repository.jpa;

import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepositoryJpa extends JpaRepository<PackJpa, Long> {
}
