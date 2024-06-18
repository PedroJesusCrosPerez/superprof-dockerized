package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.CreateAgreementUseCase;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class CreateAgreementRestController {

    private final CreateAgreementUseCase createAgreementUseCase;


    @PostMapping
    public ResponseEntity<Long> createAgreement(@RequestBody AgreementInputDto agreementInputDto) {

        Agreement createdAgreement = createAgreementUseCase.createNewAgreementWithRateAndPack(agreementInputDto);

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
//                        createAgreementUseCase.save(
////                                AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto)
//                                agreementInputDto
//                        )

                        createdAgreement.getIdAgreement()
                );
    }
}
