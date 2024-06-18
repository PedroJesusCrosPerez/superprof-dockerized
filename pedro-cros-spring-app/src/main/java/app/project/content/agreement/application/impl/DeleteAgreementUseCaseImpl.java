package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.DeleteAgreementUseCase;
import app.project.content.agreement.domain.repository.DeleteAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAgreementUseCaseImpl implements DeleteAgreementUseCase {

    private final DeleteAgreementRepository deleteAgreementRepository;


    @Override
    public Boolean delete(Long idAgreement) {

        return deleteAgreementRepository.delete(idAgreement);
    }
}
