package app.project.content.agreement.infrastructure.controller;

import app.project.content.agreement.application.DeleteAgreementUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class DeleteAgreementRestController {

    private final DeleteAgreementUseCase deleteAgreementUseCase;


    @DeleteMapping("/{idAgreement}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Acuerdo eliminado"),
            @ApiResponse(responseCode = "404", description = "No se encontró el acuerdo")
    })
    @Operation(summary = "Eliminar acuerdo")
    public ResponseEntity<Boolean> deleteAgreement(@PathVariable Long idAgreement) {

        return  ResponseEntity
                .status(
                        HttpStatus.NO_CONTENT
                )
                .body(
                        deleteAgreementUseCase.delete(idAgreement)
                );
    }
}
