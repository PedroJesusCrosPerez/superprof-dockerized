package app.project.content.agreement.infrastructure.repository.jpa;

import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepositoryJpa extends JpaRepository<AgreementJpa, Long>{
}
