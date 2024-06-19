package app.project.controller;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementsRetrieveInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AgreementController {

    private final RetrieveAgreementUseCase retrieveAgreementUseCase;

    @GetMapping("/agreement/findBySubjectName")
    public String my_agreements(
            Model model,
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String subjectName,
//            @RequestParam(required = false) Boolean isActive,
//            @RequestParam(required = false) String languageCode,
//            @RequestParam(required = false) Double pricePerHour,
            AgreementsRetrieveInputDto agreementsRetrieveInputDto,
            @RequestParam(required = false) String sortBy,
            @PageableDefault(size = 10) Pageable pageable
    ) {

        Page<AgreementOutputDtoFullOneSubject> agreementOutputDtoFullOneSubjectPage = retrieveAgreementUseCase
                .findBySubjectParams(
                        agreementsRetrieveInputDto
                        ,sortBy
                        ,pageable
                );
//                .findAllByFilter(
//                        null
//                        ,agreementsRetrieveInputDto.getSubjectName()
//                        ,agreementsRetrieveInputDto.getIsActive()
//                        ,agreementsRetrieveInputDto.getLanguageCode()
//                        ,agreementsRetrieveInputDto.getPricePerHour()
//                        ,sortBy
//                        ,pageable
//                );

        model.addAttribute(
                "agreements"
                ,agreementOutputDtoFullOneSubjectPage
        );

        model.addAttribute(
                "countAgreements"
                ,agreementOutputDtoFullOneSubjectPage.getTotalElements()
        );

        return "roles/unassigned/findBySubjectName";
    }
}
