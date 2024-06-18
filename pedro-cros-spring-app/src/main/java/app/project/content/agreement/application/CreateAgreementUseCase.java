package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.pack.domain.entity.Pack;

public interface CreateAgreementUseCase {

    Long save(Agreement agreement);

    Long save(AgreementInputDto agreementInputDto);

    Agreement addNewPackToAgreementRate(Long idAgreement, Pack pack);

    Agreement createNewAgreementWithRateAndPack(AgreementInputDto agreementInputDto);
}
