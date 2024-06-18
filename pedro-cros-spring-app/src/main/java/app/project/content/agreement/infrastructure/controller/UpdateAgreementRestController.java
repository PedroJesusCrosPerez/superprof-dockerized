package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class UpdateAgreementRestController {

    private final UpdateAgreementUseCase updateAgreementUseCase;


    @PutMapping
    public ResponseEntity<AgreementOutputDto> updateAgreement(@RequestBody AgreementInputDto agreementInputDto) {

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDto(
                                updateAgreementUseCase.update(
                                        AgreementEntityMapper.INSTANCE.toEntity(
                                                agreementInputDto
                                        )
                                )
                        )
                );
    }

    @PutMapping("/{idAgreement}/addPack")
    public ResponseEntity<AgreementOutputDto> agreementRateAddPack(
            @PathVariable Long idAgreement
            ,@RequestBody PackInputDto packInputDto
    ) {

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        AgreementDtoMapper.INSTANCE.toOutputDto(
                                updateAgreementUseCase.rateAddPack(
                                        packInputDto
                                        ,idAgreement
                                )
                        )
                );
    }
}
