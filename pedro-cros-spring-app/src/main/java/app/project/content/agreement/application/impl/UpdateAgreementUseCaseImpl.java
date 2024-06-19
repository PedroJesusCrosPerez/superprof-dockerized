package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.CreateAgreementUseCase;
import app.project.content.agreement.application.RetrieveAgreementUseCase;
import app.project.content.agreement.application.UpdateAgreementUseCase;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.UpdateAgreementRepository;
import app.project.content.language.application.LanguageUseCase;
import app.project.content.language.domain.entity.Language;
import app.project.content.pack.application.mapper.PackMapper;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.rate.application.RateUseCase;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.subject.application.RetrieveSubjectUsecase;
import app.project.content.subject.domain.entity.Subject;
import app.project.shared.exceptions.AddingExistingIdException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateAgreementUseCaseImpl implements UpdateAgreementUseCase {

    private final UpdateAgreementRepository updateAgreementRepository;
    private final RetrieveAgreementUseCase retrieveAgreementUseCase;
    private final RetrieveSubjectUsecase retrieveSubjectUsecase;
    private final LanguageUseCase languageUseCase;
    private final CreateAgreementUseCase createAgreementUseCase;
    private final RateUseCase rateUseCase;


    @Override
    public Agreement update(Agreement agreement) {

        return updateAgreementRepository.update(agreement);
    }

    @Override
    public Boolean updateTitle(String title, Long idAgreement) {

        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);
        agreement.setTitle(title);
        updateAgreementRepository.update(agreement);
        return true;
    }

    @Override
    public Boolean rateAddSubject(Long idSubject, Long idAgreement) throws AddingExistingIdException {

        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);
        List<Subject> subjects = agreement.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getIdSubject().equals(idSubject)) {
                throw new AddingExistingIdException(Agreement.class, Subject.class, idSubject);
            }
        }
        Subject subject = retrieveSubjectUsecase.findByIdSubject(idSubject);

        agreement.addSubject(subject);
        updateAgreementRepository.update(agreement);

        return null;
    }

    @Override
    public Boolean rateRemoveSubject(Long idSubject, Long idAgreement) {

        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);
        List<Subject> subjects = agreement.getSubjects();
        for (Subject subject : subjects) {
            if (subject.getIdSubject().equals(idSubject)) {
                agreement.removeSubject(subject);
                updateAgreementRepository.update(agreement);
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean rateAddLanguage(Long idLanguage, Long idAgreement) {

        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);
        List<Language> languages = agreement.getLanguages();
        for (Language language : languages) {
            if (language.getIdLanguage().equals(idLanguage)) {
                throw new AddingExistingIdException(Agreement.class, Language.class, idLanguage);
            }
        }
        Language language = languageUseCase.findById(idLanguage);

        agreement.addLanguage(language);
        updateAgreementRepository.update(agreement);

        return true;
    }

    @Override
    public Boolean rateRemoveLanguage(Long idLanguage, Long idAgreement) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    @Transactional
    public Agreement rateAddPack(PackInputDto packInputDto, Long idAgreement) {

        Pack pack = PackMapper.INSTANCE.toEntity(packInputDto);
        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);

        Rate newRate = rateUseCase.addPack(pack, agreement.getRate());

        return retrieveAgreementUseCase.findById(idAgreement);
    }

    @Override
    public Boolean rateRemovePack(PackInputDto packInputDto, Long idAgreement) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public Boolean rateAddPlace(Long idPlace, Long idAgreement) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public Boolean rateRemovePlace(Long idPlace, Long idAgreement) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public Boolean rateUpdatePricePerHour(Double pricePerHour, Long idAgreement) {

        Agreement agreement = retrieveAgreementUseCase.findById(idAgreement);
        agreement.getRate().setPricePerHour(pricePerHour);
        updateAgreementRepository.update(agreement);
        return true;
    }
}
