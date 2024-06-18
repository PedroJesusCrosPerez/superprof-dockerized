package app.project.content.agreement.application.impl;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.CreateAgreementRepository;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import app.project.content.language.application.LanguageUseCase;
import app.project.content.language.domain.entity.Language;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.repository.jpa.PackRepositoryJpa;
import app.project.content.rate.infrastructure.controller.dto.input.RateInputDto;
import app.project.content.rate.infrastructure.repository.jpa.RateRepositoryJpa;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import app.project.content.subject.application.RetrieveSubjectUsecase;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.shared.enums.EPlace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreateAgreementUseCaseImplTest {

    @Mock
    private CreateAgreementRepository createAgreementRepository;

    @Mock
    private RetrieveSubjectUsecase retrieveSubjectUseCase;

    @Mock
    private SubjectRepositoryJpa subjectRepositoryJpa;

    @Mock
    private LanguageUseCase languageUseCase;

    @Mock
    private PackRepositoryJpa packRepositoryJpa;

    @Mock
    private AgreementRepositoryJpa agreementRepositoryJpa;

    @Mock
    private RateRepositoryJpa rateRepositoryJpa;

    @InjectMocks
    private CreateAgreementUseCaseImpl createAgreementUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        // Given
        AgreementInputDto agreementInputDto = new AgreementInputDto();
        agreementInputDto.setTitle("Sample Agreement");
        agreementInputDto.setDescription("Sample Description");
        agreementInputDto.setAboutMe("About Me");
        agreementInputDto.setIdsLanguages(List.of(1L, 2L));

        // Mock behavior for languageUseCase.findById()
        when(languageUseCase.findById(any())).thenReturn(new Language());

        // Mock behavior for createAgreementRepository.save()
        when(createAgreementRepository.save(any())).thenReturn(1L);

        // When
        Long savedAgreementId = createAgreementUseCase.save(agreementInputDto);

        // Then
        assertEquals(1L, savedAgreementId);

        // Verify interactions
        verify(languageUseCase, times(2)).findById(any()); // Called twice for each language ID
        verify(createAgreementRepository, times(1)).save(any()); // Called once to save Agreement
    }

    @Test
    void testCreateNewAgreementWithRateAndPack() {
        // Given
        AgreementInputDto agreementInputDto = new AgreementInputDto();
        agreementInputDto.setTitle("Sample Agreement");
        agreementInputDto.setDescription("Sample Description");
        agreementInputDto.setAboutMe("About Me");
        agreementInputDto.setPlaces(List.of(EPlace.ONLINE));
        agreementInputDto.setIdsSubjects(List.of(1L, 2L));
        agreementInputDto.setIdsLanguages(List.of(1L, 2L));
        RateInputDto rateInputDto = new RateInputDto();
        rateInputDto.setPricePerHour(10.0);
        PackInputDto packInputDto1 = new PackInputDto();
        packInputDto1.setHours("50");
        packInputDto1.setPrice(10.0);
        rateInputDto.setPacks(List.of(packInputDto1));
        agreementInputDto.setRate(rateInputDto);

        // Mock behavior for subjectRepositoryJpa.findById()
        when(subjectRepositoryJpa.findById(any())).thenReturn(Optional.of(new SubjectJpa()));

        // Mock behavior for languageUseCase.findById()
        when(languageUseCase.findById(any())).thenReturn(new Language());

        // Mock behavior for agreementRepositoryJpa.save()
        when(agreementRepositoryJpa.save(any())).thenReturn(new AgreementJpa());

        // Mock behavior for rateRepositoryJpa.save()
        when(rateRepositoryJpa.save(any())).thenReturn(new RateJpa());

        // When
        Agreement resultAgreement = createAgreementUseCase.createNewAgreementWithRateAndPack(agreementInputDto);

        // Then
        assertEquals(agreementInputDto.getTitle(), resultAgreement.getTitle());
        assertEquals(agreementInputDto.getDescription(), resultAgreement.getDescription());
        assertEquals(agreementInputDto.getAboutMe(), resultAgreement.getAboutMe());
        assertEquals(agreementInputDto.getPlaces(), resultAgreement.getPlaces());

        // Verify interactions
        verify(subjectRepositoryJpa, times(2)).findById(any()); // Called twice for each subject ID
        verify(languageUseCase, times(2)).findById(any()); // Called twice for each language ID
        verify(agreementRepositoryJpa, times(2)).save(any()); // Called once to save AgreementJpa
        verify(rateRepositoryJpa, times(1)).save(any()); // Called once to save RateJpa
    }




/*
    @Test
    void testAddNewPackToAgreementRate() {
        // Given
        Long agreementId = 1L;
        AgreementJpa agreementJpa = new AgreementJpa();
        when(agreementRepositoryJpa.findById(eq(agreementId))).thenReturn(Optional.of(agreementJpa));

        RateJpa rateJpa = new RateJpa();

        Pack newPack = new Pack();
        newPack.setHours("50");
        newPack.setPrice(10.0);
        rateJpa.setPacks(List.of(new PackJpa()));

        agreementJpa.setRate(rateJpa);

        // Mock behavior for packRepositoryJpa.save()
        when(packRepositoryJpa.save(any())).thenReturn(new PackJpa());

        // When
        Agreement resultAgreement = createAgreementUseCase.addNewPackToAgreementRate(agreementId, newPack);

        // Then
        assertEquals(agreementJpa, AgreementEntityMapper.INSTANCE.toEntityJpa(resultAgreement));

        // Verify interactions
        verify(agreementRepositoryJpa, times(1)).findById(eq(agreementId)); // Called once to find AgreementJpa
        verify(packRepositoryJpa, times(1)).save(any()); // Called once to save PackJpa
        verify(rateRepositoryJpa, times(1)).save(eq(rateJpa)); // Called once to save RateJpa
        verify(agreementRepositoryJpa, times(1)).save(eq(agreementJpa)); // Called once to save AgreementJpa
    }
    */
}
