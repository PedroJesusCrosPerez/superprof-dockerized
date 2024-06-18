package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;

public interface UpdateAgreementUseCase {

    Agreement update(Agreement agreement);
    Agreement rateAddPack(PackInputDto packInputDto, Long idAgreement);
}
