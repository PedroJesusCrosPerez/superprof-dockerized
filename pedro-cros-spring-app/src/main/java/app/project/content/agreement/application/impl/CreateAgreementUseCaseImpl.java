package app.project.content.agreement.application.impl;

import app.project.content.agreement.application.CreateAgreementUseCase;
import app.project.content.agreement.application.mapper.AgreementEntityMapper;
import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import app.project.content.language.application.LanguageUseCase;
import app.project.content.language.application.mapper.LanguageMapper;
import app.project.content.language.infrastructure.repository.jpa.LanguageRepositoryJpa;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import app.project.content.pack.application.mapper.PackMapper;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.repository.jpa.PackRepositoryJpa;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import app.project.content.rate.infrastructure.controller.dto.input.RateInputDto;
import app.project.content.rate.infrastructure.repository.jpa.RateRepositoryJpa;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import app.project.content.subject.application.RetrieveSubjectUsecase;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.shared.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateAgreementUseCaseImpl implements CreateAgreementUseCase {

    // Agreement repo
    private final CreateAgreementRepository createAgreementRepository;

        // Dependencies =>
    private final RetrieveSubjectUsecase retrieveSubjectUseCase;

    private final SubjectRepositoryJpa subjectRepositoryJpa;
    private final LanguageUseCase languageUseCase;
    private final PackRepositoryJpa packRepositoryJpa;
    private final AgreementRepositoryJpa agreementRepositoryJpa;
    private final RateRepositoryJpa rateRepositoryJpa;
    private final LanguageRepositoryJpa languageRepositoryJpa;


    @Override
    @Transactional
    public Long save(AgreementInputDto agreementInputDto) {

        Agreement agreement = AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto);

        // Languages
        for (Long idLanguage : agreementInputDto.getIdsLanguages()) {
            agreement.addLanguage(
                    languageUseCase.findById(idLanguage)
            );
        }

        return createAgreementRepository.save(agreement);
    }


    @Override
    @Transactional
    public Agreement addNewPackToAgreementRate(Long idAgreement, Pack newPack) {

        // Recuperar la entidad AgreementJpa con ID especificado
        AgreementJpa agreementJpa = agreementRepositoryJpa.findById(idAgreement).orElseThrow(
                () -> new NotFoundException(Agreement.class, idAgreement)
        );

        // Crear y configurar el nuevo Pack
        PackJpa newPackJpa = PackMapper.INSTANCE.toEntityJpa(newPack);

        // Obtener el RateJpa asociado a la entidad AgreementJpa
        RateJpa rateJpa = agreementJpa.getRate();

        // Establecer el RateJpa en el nuevo Pack
        newPackJpa.setRate(rateJpa);

        // Asegurarse de que la colección de packs esté inicializada
        List<PackJpa> packs = rateJpa.getPacks();
        packs.add(newPackJpa);
        rateJpa.setPacks(packs);

        // Guardar el RateJpa actualizado
        rateRepositoryJpa.save(rateJpa);

        // Guardar la entidad AgreementJpa actualizada
        agreementRepositoryJpa.save(agreementJpa);

        return AgreementEntityMapper.INSTANCE.toEntity(agreementJpa);
    }


    @Override
    @Transactional
    public Agreement createNewAgreementWithRateAndPack(AgreementInputDto agreementInputDto) {

        // Create and config new Pack(s)
        List<PackJpa> packJpaList = agreementInputDto.getRate().getPacks().stream().map(packInputDto -> {
            PackJpa packJpa = new PackJpa();
            packJpa.setHours(packInputDto.getHours());
            packJpa.setPrice(packInputDto.getPrice());
            return packJpa;
        }).collect(Collectors.toList());

        // Create and config new Rate
        RateInputDto rateInputDto = agreementInputDto.getRate();
        RateJpa rateJpa = new RateJpa();
        rateJpa.setPricePerHour(rateInputDto.getPricePerHour());
        rateJpa.setPacks(packJpaList);

        // Create and config new Agreement
        AgreementJpa agreementJpa = new AgreementJpa();
        agreementJpa.setTitle(agreementInputDto.getTitle());
        agreementJpa.setDescription(agreementInputDto.getDescription());
        agreementJpa.setAboutMe(agreementInputDto.getAboutMe());
        agreementJpa.setPlaces(agreementInputDto.getPlaces());

        // GET and SET Subjects
//        List<SubjectJpa> subjectsJpaList = agreementInputDto.getIdsSubjects().stream()
//                .map(retrieveSubjectUseCase::findByIdSubject)
//                .map(SubjectEntityMapper.INSTANCE::toEntityJpa)
//                .collect(Collectors.toList());
//        agreementJpa.setSubjects(subjectsJpaList);
        List<Long> idsSubjectsList = agreementInputDto.getIdsSubjects();
        for (Long idSubject : idsSubjectsList) {
            SubjectJpa subjectJpa = subjectRepositoryJpa.findById(idSubject).orElseThrow(
                    () -> new NotFoundException(SubjectJpa.class, idSubject)
            );
            agreementJpa.addSubject(subjectJpa);
        }



        // GET and SET Languages
        List<LanguageJpa> languages = agreementInputDto.getIdsLanguages().stream()
                .map(languageUseCase::findById)
                .map(LanguageMapper.INSTANCE::toEntityJpa)
                .collect(Collectors.toList());
        agreementJpa.setLanguages(languages);

        // Save Agreement to take ID
        agreementRepositoryJpa.save(agreementJpa);

        // Config relations
        packJpaList.forEach(packJpa -> packJpa.setRate(rateJpa));
        agreementJpa.setRate(rateJpa);

        // Save relation entities
        rateRepositoryJpa.save(rateJpa);
        agreementRepositoryJpa.save(agreementJpa);

        return AgreementEntityMapper.INSTANCE.toEntity(agreementJpa);
    }

    @Override
    public Long save(Agreement agreement) {
        return 99L;
    }

//    @Override
//    @Transactional
//    public Long save(AgreementInputDto agreementInputDto) {
//        Agreement agreement = AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto);
//        // Languages
//        for (Long idLanguage : agreementInputDto.getIdsLanguages()) {
//            agreement.addLanguage(
//                    languageUseCase.findById(idLanguage)
//            );
//        }
//        AgreementJpa agreementJpa = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement);
//
//        // Set the rate for each pack
//        RateJpa rateJpa = agreementJpa.getRate();
//        if (rateJpa != null) {
//            for (PackJpa pack : rateJpa.getPacks()) {
//                pack.setRate(rateJpa);
//            }
//            rateRepositoryJpa.save(rateJpa);
//        }
//
//        // Save the agreement with the associated rate
//        agreementRepositoryJpa.save(agreementJpa);
//
//        return agreementJpa.getIdAgreement();
//    }

//    @Override
//    @Transactional
//    public Agreement createNewAgreementWithRateAndPack(AgreementInputDto agreementInputDto) {
//
//        // Create and config new Pack(s)
//        List<PackJpa> packJpaList = agreementInputDto.getRate().getPacks().stream().map(packInputDto -> {
//            PackJpa packJpa = new PackJpa();
//            packJpa.setHours(packInputDto.getHours());
//            packJpa.setPrice(packInputDto.getPrice());
//            return packJpa;
//        }).collect(Collectors.toList());
//
//        // Create and config new Rate
//        RateInputDto rateInputDto = agreementInputDto.getRate();
//        RateJpa rateJpa = new RateJpa();
//        rateJpa.setPricePerHour(rateInputDto.getPricePerHour());
//        rateJpa.setPacks(packJpaList);
//
//        // Create and config new Agreement
//        AgreementJpa agreementJpa = new AgreementJpa();
//        agreementJpa.setTitle(agreementInputDto.getTitle());
//        agreementJpa.setDescription(agreementInputDto.getDescription());
//        agreementJpa.setAboutMe(agreementInputDto.getAboutMe());
//        agreementJpa.setPlaces(agreementInputDto.getPlaces());
//
//        // GET and SET Subjects
//        List<SubjectJpa> subjectsJpaList = agreementInputDto.getIdsSubjects().stream()
//                .map(retrieveSubjectUseCase::findByIdSubject)
//                .map(SubjectEntityMapper.INSTANCE::toEntityJpa)
//                .collect(Collectors.toList());
//
//        // Save Subjects to take IDs
////        subjectsJpaList.forEach(subjectJpa -> subjectRepositoryJpa.save(subjectJpa));
//        subjectRepositoryJpa.saveAll(subjectsJpaList);
//
//        agreementJpa.setSubjects(subjectsJpaList);
//
//        // GET and SET Languages
//        List<LanguageJpa> languages = agreementInputDto.getIdsLanguages().stream()
//                .map(languageUseCase::findById)
//                .map(LanguageMapper.INSTANCE::toEntityJpa)
//                .collect(Collectors.toList());
//
//        // Save Languages to take IDs
////        languages.forEach(languageJpa -> languageRepositoryJpa.save(languageJpa));
//        languageRepositoryJpa.saveAll(languages);
//
//        agreementJpa.setLanguages(languages);
//
//        // Save Packs to take IDs
////        packJpaList.forEach(packJpa -> packRepositoryJpa.save(packJpa));
//        packRepositoryJpa.saveAll(packJpaList);
//
//        // Config relations
//        packJpaList.forEach(packJpa -> packJpa.setRate(rateJpa));
//        rateRepositoryJpa.save(rateJpa);
//        agreementJpa.setRate(rateJpa);
//
//        // Save Agreement to take ID
//        agreementRepositoryJpa.save(agreementJpa);
//
//        return AgreementEntityMapper.INSTANCE.toEntity(agreementJpa);
//    }
}
