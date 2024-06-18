package app.project.content.agreement.domain.repository;

import app.project.content.agreement.domain.entity.Agreement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RetrieveAgreementRepository {

    Agreement findById(Long idAgreement);

    List<Agreement> findAll();

    Page<Agreement> findAll(Pageable pageable);
}
