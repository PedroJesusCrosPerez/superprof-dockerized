package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementsRetrieveInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveAgreementUseCaseImpl implements RetrieveAgreementUseCase {

    private final RetrieveAgreementRepository retrieveAgreementRepository;
    private final EntityManager entityManager; 


    @Override
    public Agreement findById(Long idAgreement) {

        return retrieveAgreementRepository.findById(idAgreement);
    }

    @Override
    public List<Agreement> findAll() {

        List<Agreement> agreementList = retrieveAgreementRepository.findAll();

        return agreementList;
//        return retrieveAgreementRepository.findAll();
    }

    @Override
    public Page<Agreement> findAll(Pageable pageable) {

        return retrieveAgreementRepository.findAll(pageable);
    }

    @Override
    public Page<AgreementOutputDtoFullOneSubject> findAllByFilter(String title, String subjectName, Boolean isActive, String languageCode, Double pricePerHour, String sortBy, Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AgreementJpa> query = cb.createQuery(AgreementJpa.class);
        Root<AgreementJpa> agreement = query.from(AgreementJpa.class);
        Join<AgreementJpa, SubjectJpa> subject = agreement.join("subjects", JoinType.LEFT);

        Predicate criteria = cb.conjunction();

        if (title != null) {
            criteria = cb.and(criteria, cb.equal(agreement.get("title"), title));
        }

        if (subjectName != null) {
            criteria = cb.and(criteria, cb.equal(subject.get("name"), subjectName));
        }

        if (isActive != null) {
            criteria = cb.and(criteria, cb.equal(agreement.get("isActive"), isActive));
        }
//        if (createdDate != null) {
//            criteria = cb.and(criteria, cb.lessThanOrEqualTo(agreement.get("createdDate"), createdDate));
//        }

        query.where(criteria);

        if ("usuario".equalsIgnoreCase(sortBy)) {
            query.orderBy(cb.asc(agreement.get("usuario")));
        } else if ("name".equalsIgnoreCase(sortBy)) {
            query.orderBy(cb.asc(agreement.get("name")));
        }

        TypedQuery<AgreementJpa> typedQuery = entityManager.createQuery(query);
        int totalRows = typedQuery.getResultList().size();
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<AgreementJpa> result = typedQuery.getResultList();

        Page<AgreementJpa> agreementJpaPage = new PageImpl<>(result, pageable, totalRows);
        Page<Agreement> agreementPage = agreementJpaPage.map(AgreementEntityMapper.INSTANCE::toEntity);
        Page<AgreementOutputDtoFullOneSubject> agreementOutputFullOneSubjectPage = agreementPage.map(AgreementDtoMapper.INSTANCE::toOutputDtoFullOneSubject);

        return agreementOutputFullOneSubjectPage;
    }

    @Override
    public Page<AgreementOutputDtoFullOneSubject> findBySubjectParams(String subjectName, Boolean isActive, String languageCode, Double pricePerHour, String sortBy, Pageable pageable) {

        return this.findAllByFilter(null, subjectName, isActive, languageCode, pricePerHour, sortBy, pageable);
    }

    @Override
    public Page<AgreementOutputDtoFullOneSubject> findBySubjectParams(AgreementsRetrieveInputDto agreementsRetrieveInputDto, String sortBy, Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AgreementJpa> query = cb.createQuery(AgreementJpa.class);
        Root<AgreementJpa> agreement = query.from(AgreementJpa.class);
        Join<AgreementJpa, SubjectJpa> subject = agreement.join("subjects", JoinType.LEFT);

        Predicate criteria = cb.conjunction();

        if (agreementsRetrieveInputDto.getTitle() != null) {
            criteria = cb.and(criteria, cb.equal(agreement.get("title"), agreementsRetrieveInputDto.getTitle()));
        }

        if (agreementsRetrieveInputDto.getSubjectName() != null) {
            criteria = cb.and(criteria, cb.equal(subject.get("name"), agreementsRetrieveInputDto.getSubjectName()));
        }

        if (agreementsRetrieveInputDto.getIsActive() != null) {
            criteria = cb.and(criteria, cb.equal(agreement.get("isActive"), agreementsRetrieveInputDto.getIsActive()));
        }

        if (agreementsRetrieveInputDto.getCreatedDate() != null) {
            criteria = cb.and(criteria, cb.lessThanOrEqualTo(agreement.get("createdDate"), agreementsRetrieveInputDto.getCreatedDate()));
        }

        query.where(criteria);

        // SORT
//        if ("usuario".equalsIgnoreCase(sortBy)) {
//            query.orderBy(cb.asc(agreement.get("usuario")));
//        } else if ("name".equalsIgnoreCase(sortBy)) {
//            query.orderBy(cb.asc(agreement.get("name")));
//        }

        // Sort by Place if is specified
        if ("place".equalsIgnoreCase(sortBy)) {
            query.orderBy(cb.asc(agreement.get("place")));
        } else {
            // Sort by other fields
            if ("usuario".equalsIgnoreCase(sortBy)) {
                query.orderBy(cb.asc(agreement.get("usuario")));
            } else if ("name".equalsIgnoreCase(sortBy)) {
                query.orderBy(cb.asc(agreement.get("name")));
            }
        }

        TypedQuery<AgreementJpa> typedQuery = entityManager.createQuery(query);
        int totalRows = typedQuery.getResultList().size();
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<AgreementJpa> result = typedQuery.getResultList();

        Page<AgreementJpa> agreementJpaPage = new PageImpl<>(result, pageable, totalRows);
        Page<Agreement> agreementPage = agreementJpaPage.map(AgreementEntityMapper.INSTANCE::toEntity);
        Page<AgreementOutputDtoFullOneSubject> agreementOutputFullOneSubjectPage = agreementPage.map(AgreementDtoMapper.INSTANCE::toOutputDtoFullOneSubject);

        return agreementOutputFullOneSubjectPage;
    }



}
