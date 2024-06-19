package app.project.content.agreement.application;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.shared.exceptions.AddingExistingIdException;

public interface UpdateAgreementUseCase {

    Agreement update(Agreement agreement);

    Boolean updateTitle(String title, Long idAgreement);
    Boolean rateAddSubject(Long idSubject, Long idAgreement) throws AddingExistingIdException;
    Boolean rateRemoveSubject(Long idSubject, Long idAgreement);
    Boolean rateAddLanguage(Long idLanguage, Long idAgreement) throws AddingExistingIdException;
    Boolean rateRemoveLanguage(Long idLanguage, Long idAgreement);
    Agreement rateAddPack(PackInputDto packInputDto, Long idAgreement) throws AddingExistingIdException;
    Boolean rateRemovePack(PackInputDto packInputDto, Long idAgreement);
    Boolean rateAddPlace(Long idPlace, Long idAgreement) throws AddingExistingIdException;
    Boolean rateRemovePlace(Long idPlace, Long idAgreement);
    Boolean rateUpdatePricePerHour(Double pricePerHour, Long idAgreement);
}
