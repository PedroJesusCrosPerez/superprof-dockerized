package app.project.content.language.infrastructure.repository.jpa;

import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepositoryJpa extends JpaRepository<LanguageJpa, Long> {
}
