package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementsRetrieveInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFull;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class RetrieveAgreementRestController {

    private final RetrieveAgreementUseCase retrieveAgreementUseCase;


    @GetMapping
    public ResponseEntity<List<?>> findAll(
            @RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        if (outerType.equals("full")) {

            List<Agreement> agreementsList = retrieveAgreementUseCase.findAll();
            List<AgreementOutputDtoFull> agreementsDtoFullList = AgreementDtoMapper.INSTANCE.toOutputDtoListFull(agreementsList);

            return ResponseEntity
                    .status(
                            HttpStatus.OK
                    )
                    .body(
//                            AgreementDtoMapper.INSTANCE.toOutputDtoListFull(
//                                    retrieveAgreementUseCase.findAll()
//                            )
                            agreementsDtoFullList
                    );
        }


        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDtoList(
                                retrieveAgreementUseCase.findAll()
                        )
                );
    }

    @GetMapping("/{idAgreement}")
    public ResponseEntity<AgreementOutputDto> findById(@PathVariable Long idAgreement) {

        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDto(
                                retrieveAgreementUseCase.findById(idAgreement)
                        )
                );
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<AgreementOutputDtoFull>> findAllPageable(
            @PageableDefault(page = 0, size = 5) Pageable pageable
    ) {

        Page<Agreement> agreementsPage =  retrieveAgreementUseCase.findAll(pageable);

        Page<AgreementOutputDtoFull> agreementOutputDtoFullPage = agreementsPage.map(AgreementDtoMapper.INSTANCE::toOutputDtoFull);

        return ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        agreementOutputDtoFullPage
                );
    }

    @GetMapping("/search")
    public ResponseEntity<Page<AgreementOutputDtoFullOneSubject>> findAllCriteriaBuilder(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String subjectName,
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) String languageCode,
            @RequestParam(required = false) Double pricePerHour,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdDate,
            @RequestParam(required = false) String sortBy,
            @PageableDefault(size = 10) Pageable pageable
    ) {

        AgreementsRetrieveInputDto agreementsRetrieveInputDto = new AgreementsRetrieveInputDto();
        agreementsRetrieveInputDto.setTitle(title);
        agreementsRetrieveInputDto.setSubjectName(subjectName);
        agreementsRetrieveInputDto.setIsActive(isActive);
        agreementsRetrieveInputDto.setLanguageCode(languageCode);
        agreementsRetrieveInputDto.setPricePerHour(pricePerHour);
        agreementsRetrieveInputDto.setCreatedDate(createdDate);

        Page<AgreementOutputDtoFullOneSubject> agreementOutputDtoFullOneSubjectPage = retrieveAgreementUseCase.findBySubjectParams(agreementsRetrieveInputDto, sortBy, pageable);

        if ("place".equalsIgnoreCase(sortBy)) {
            agreementOutputDtoFullOneSubjectPage = retrieveAgreementUseCase.findBySubjectParams(agreementsRetrieveInputDto, "place", pageable);
        } else {
            agreementOutputDtoFullOneSubjectPage = retrieveAgreementUseCase.findBySubjectParams(agreementsRetrieveInputDto, sortBy, pageable);
        }

        if (agreementOutputDtoFullOneSubjectPage.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(agreementOutputDtoFullOneSubjectPage);
        }
    }
}
