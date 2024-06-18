package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementsRetrieveInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RetrieveAgreementUseCase {

    Agreement findById(Long idAgreement);

    List<Agreement> findAll();

    Page<Agreement> findAll(Pageable pageable);

    Page<AgreementOutputDtoFullOneSubject> findAllByFilter(String title, String subjectName, Boolean isActive, String languageCode, Double pricePerHour, String sortBy, Pageable pageable);

    Page<AgreementOutputDtoFullOneSubject> findBySubjectParams(String subjectName, Boolean isActive, String languageCode, Double pricePerHour, String sortBy, Pageable pageable);

    Page<AgreementOutputDtoFullOneSubject> findBySubjectParams(AgreementsRetrieveInputDto agreementsRetrieveInputDto, String sortBy, Pageable pageable);
}
