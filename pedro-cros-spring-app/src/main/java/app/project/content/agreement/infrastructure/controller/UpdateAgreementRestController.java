package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementDtoMapper;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementPatchUpdateInputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Acuerdo actualizado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada")
    })
    @Operation(summary = "Actualizar acuerdo")
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Acuerdo actualizado con pack"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada")
    })
    @Operation(summary = "Actualizar acuerdo con pack")
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

    @PatchMapping("/{idAgreement}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acuerdo actualizado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada")
    })
    @Operation(summary = "Actualizar parcialmente acuerdo")
    public ResponseEntity<Boolean> partialUpdateAgreement(
            @PathVariable Long idAgreement,
            @RequestBody AgreementPatchUpdateInputDto agreementPartialUpdateDto
    ) {

        if (agreementPartialUpdateDto.getTitle() != null) {
            updateAgreementUseCase.updateTitle(
                    agreementPartialUpdateDto.getTitle()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getAddIdSubject() != null) {
            updateAgreementUseCase.rateAddSubject(
                    agreementPartialUpdateDto.getAddIdSubject()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getRemoveIdSubject() != null) {
            updateAgreementUseCase.rateRemoveSubject(
                    agreementPartialUpdateDto.getRemoveIdSubject()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getAddIdLanguage() != null) {
            updateAgreementUseCase.rateAddLanguage(
                    agreementPartialUpdateDto.getAddIdLanguage()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getRemoveIdLanguage() != null) {
            updateAgreementUseCase.rateRemoveLanguage(
                    agreementPartialUpdateDto.getRemoveIdLanguage()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getAddIdPlace() != null) {
            updateAgreementUseCase.rateAddPlace(
                    agreementPartialUpdateDto.getAddIdPlace()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getRemoveIdPlace() != null) {
            updateAgreementUseCase.rateRemovePlace(
                    agreementPartialUpdateDto.getRemoveIdPlace()
                    ,idAgreement
            );
        }
        if (agreementPartialUpdateDto.getPricePerHour() != null) {
            updateAgreementUseCase.rateUpdatePricePerHour(
                    agreementPartialUpdateDto.getPricePerHour()
                    ,idAgreement
            );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.OK
                )
                .body(
                        true
                );
    }
}
