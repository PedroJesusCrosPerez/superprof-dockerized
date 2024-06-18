package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import app.project.content.rate.infrastructure.repository.jpa.RateRepositoryJpa;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateAgreementRepositoryImpl implements CreateAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;
    private final RateRepositoryJpa rateRepositoryJpa;


    @Override
    @Transactional
    public Long save(Agreement agreement) {


        AgreementJpa agreementJpa = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement);

        // Set the rate for each pack
        RateJpa rateJpa = agreementJpa.getRate();
        if (rateJpa != null) {
            for (PackJpa pack : rateJpa.getPacks()) {
                pack.setRate(rateJpa);
            }
            rateRepositoryJpa.save(rateJpa);
        }

        // Save the agreement with the associated rate
        return agreementRepositoryJpa.save(agreementJpa).getIdAgreement();

/*
        AgreementJpa agreementJpa = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement);
        RateJpa rateJpa = agreementJpa.getRate();
//        List<PackJpa> packJpaList = agreementJpa.getRate().getPacks();
//        for (PackJpa packJpa : packJpaList) {
//            packJpa.setRate(rateJpa);
//            packJpa.getRate().setPacks(null);
//        }

        return agreementRepositoryJpa.save(
//                AgreementEntityMapper.INSTANCE.toEntityJpa(agreement)
                agreementJpa
        ).getIdAgreement();
 */
    }
}
