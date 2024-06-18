package app.project.content.agreement.application.impl;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.domain.repository.RetrieveAgreementRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetrieveAgreementUseCaseImplTest {

    @Test
    void findById() {
        // Mock data
        Long id = 1L;
        Agreement expectedAgreement = new Agreement();
        expectedAgreement.setIdAgreement(id);
        expectedAgreement.setTitle("Sample Agreement");
        expectedAgreement.setDescription("Sample description");
        expectedAgreement.setIsActive(true);

        // Mock repository
        RetrieveAgreementRepository retrieveAgreementRepository = mock(RetrieveAgreementRepository.class);
        when(retrieveAgreementRepository.findById(id)).thenReturn(expectedAgreement);

        // Create instance of RetrieveAgreementUseCaseImpl
        RetrieveAgreementUseCaseImpl retrieveAgreementUseCase = new RetrieveAgreementUseCaseImpl(retrieveAgreementRepository, null);

        // Call method
        Agreement result = retrieveAgreementUseCase.findById(id);

        // Assertions
        assertNotNull(result);
        assertEquals(id, result.getIdAgreement());
        assertEquals("Sample Agreement", result.getTitle());
        assertEquals("Sample description", result.getDescription());
        assertTrue(result.getIsActive());
        verify(retrieveAgreementRepository, times(1)).findById(id);
    }

    @Test
    void findAll() {
        // Mock data
        Agreement agreement1 = new Agreement();
        agreement1.setIdAgreement(1L);
        agreement1.setTitle("Agreement 1");
        agreement1.setDescription("Description 1");
        agreement1.setAboutMe("About me 1");
        agreement1.setIsActive(true);

        Agreement agreement2 = new Agreement();
        agreement2.setIdAgreement(2L);
        agreement2.setTitle("Agreement 2");
        agreement2.setDescription("Description 2");
        agreement2.setAboutMe("About me 2");
        agreement2.setIsActive(true);

        List<Agreement> expectedAgreements = Arrays.asList(agreement1, agreement2);

        // Mock repository
        RetrieveAgreementRepository retrieveAgreementRepository = mock(RetrieveAgreementRepository.class);
        when(retrieveAgreementRepository.findAll()).thenReturn(expectedAgreements);

        // Create instance of RetrieveAgreementUseCaseImpl
        RetrieveAgreementUseCaseImpl retrieveAgreementUseCase = new RetrieveAgreementUseCaseImpl(retrieveAgreementRepository, null);

        // Call method
        List<Agreement> result = retrieveAgreementUseCase.findAll();

        // Assertions
        assertNotNull(result);
        assertEquals(expectedAgreements.size(), result.size());
        assertEquals(expectedAgreements.get(0).getIdAgreement(), result.get(0).getIdAgreement());
        assertEquals(expectedAgreements.get(1).getIdAgreement(), result.get(1).getIdAgreement());
        // Add more assertions as needed
        verify(retrieveAgreementRepository, times(1)).findAll();
    }
}