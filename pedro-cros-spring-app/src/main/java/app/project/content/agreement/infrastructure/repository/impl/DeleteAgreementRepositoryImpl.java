package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.domain.repository.DeleteAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteAgreementRepositoryImpl implements DeleteAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;


    @Override
    public Boolean delete(Long idAgreement) {

        if (!agreementRepositoryJpa.existsById(idAgreement)) {
            return false;
        }
        agreementRepositoryJpa.deleteById(idAgreement);

        return true;
    }
}
