package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.UpdateAgreementRepository;
import app.project.content.pack.application.mapper.PackMapper;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.rate.application.RateUseCase;
import app.project.content.rate.domain.entity.Rate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAgreementUseCaseImpl implements UpdateAgreementUseCase {

    private final UpdateAgreementRepository updateAgreementRepository;
    private final RetrieveAgreementUseCase retrieveAgreementUseCase;
    private final RateUseCase rateUseCase;


    @Override
    public Agreement update(Agreement agreement) {

        return updateAgreementRepository.update(agreement);
    }

    @Override
    @Transactional
    public Agreement rateAddPack(PackInputDto packInputDto, Long idAgreement) {

        Pack pack = PackMapper.INSTANCE.toEntity(packInputDto);
        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);

        Rate newRate = rateUseCase.addPack(pack, agreement.getRate());

        return retrieveAgreementUseCase.findById(idAgreement);
    }
}
