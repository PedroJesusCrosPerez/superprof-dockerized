package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.UpdateAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateAgreementRepositoryImpl implements UpdateAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;


    @Override
    public Agreement update(Agreement agreement) {

        agreementRepositoryJpa.save(
                AgreementEntityMapper.INSTANCE.toEntityJpa(agreement)
        );

        return agreement;
    }
}
