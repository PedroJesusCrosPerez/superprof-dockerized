package app.project.content.agreement.infrastructure.repository.impl;

import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveAgreementRepositoryImpl implements RetrieveAgreementRepository {

    private final AgreementRepositoryJpa agreementRepositoryJpa;


    @Override
    public Agreement findById(Long idAgreement) {

        return agreementRepositoryJpa.findById(idAgreement)
                .map(AgreementEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new NotFoundException(Agreement.class, idAgreement)
                );
    }

    @Override
    public List<Agreement> findAll() {

//        List<AgreementJpa> agreementJpaList = agreementRepositoryJpa.findAll();
//        return agreementJpaList.stream()
//                .filter(this::hasNonEmptySubjects)
//                .map(AgreementEntityMapper.INSTANCE::toEntity)
//                .peek(this::postProcessAgreement)
//                .collect(Collectors.toList());

        return agreementRepositoryJpa.findAll().stream()
                .map(AgreementEntityMapper.INSTANCE::toEntity)
                .toList();
    }

//    private boolean hasNonEmptySubjects(AgreementJpa agreementJpa) {
//        return agreementJpa.getSubjects() != null && !agreementJpa.getSubjects().isEmpty();
//    }
//
//    private void postProcessAgreement(Agreement agreement) {
//        if (agreement.getSubjects() != null) {
//            agreement.getSubjects().forEach(subject -> subject.setAgreements(null));
//        }
//    }

    @Override
    public Page<Agreement> findAll(Pageable pageable) {

        return agreementRepositoryJpa.findAll(pageable)
                .map(AgreementEntityMapper.INSTANCE::toEntity);
    }
}
