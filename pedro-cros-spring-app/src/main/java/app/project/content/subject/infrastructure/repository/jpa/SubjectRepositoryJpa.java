package app.project.content.subject.infrastructure.repository.jpa;

import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepositoryJpa extends JpaRepository<SubjectJpa, Long> {
}
