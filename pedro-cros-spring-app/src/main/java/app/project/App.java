package app.project;

import app.project.content.language.infrastructure.repository.jpa.LanguageRepositoryJpa;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import app.project.content.role.domain.entity.Role;
import app.project.content.role.domain.repository.RoleRepository;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.shared.enums.ERole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        // Roles
        var roleRepository = context.getBean(RoleRepository.class);
        Role role1 = new Role(ERole.ROLE_ADMIN);
        Role role2 = new Role(ERole.ROLE_TEACHER);
        Role role3 = new Role(ERole.ROLE_USER);
        Role role4 = new Role(ERole.ROLE_UNASSIGNED);

        roleRepository.saveAll(Arrays.asList(role1, role2, role3, role4));

//        Insertar datos de ejemplo







        // SUBJECT
        var subjectRepositoryJpa = context.getBean(SubjectRepositoryJpa.class);

        SubjectJpa s1 = new SubjectJpa();
        s1.setName("programacion");
        SubjectJpa s2 = new SubjectJpa();
        s2.setName("matemáticas");
        SubjectJpa s3 = new SubjectJpa();
        s3.setName("lengua");
        SubjectJpa s4 = new SubjectJpa();
        s4.setName("geografía");
        subjectRepositoryJpa.saveAll(Arrays.asList(s1,s2,s3,s4));

        // LANGUAGE
        var languageRepositoryJpa = context.getBean(LanguageRepositoryJpa.class);
        LanguageJpa l1 = new LanguageJpa();
        l1.setName("español");
        l1.setCode("es");
        LanguageJpa l2 = new LanguageJpa();
        l2.setName("english");
        l2.setCode("en");
        LanguageJpa l3 = new LanguageJpa();
        l3.setName("french");
        l3.setCode("fr");

        languageRepositoryJpa.saveAll(Arrays.asList(l1,l2,l3));
    /*
        // Pack
        var packRepositoryJpa = context.getBean(PackRepositoryJpa.class);
        PackJpa pack1 = new PackJpa();
        pack1.setIdPack(null);
        pack1.setHours("10");
        pack1.setPrice(50.0);
        pack1.setRate(null);

        // Rate
        var rateRepositoryJpa = context.getBean(RateRepositoryJpa.class);
        RateJpa rate1 = new RateJpa();
        rate1.setIdRate(null);
        rate1.setPricePerHour(5.0);
        rate1.setPacks(List.of(pack1));

        // Agreements
        var agreementRepositoryJpa = context.getBean(AgreementRepositoryJpa.class);
        AgreementJpa agreement1 = new AgreementJpa();
        agreement1.setTitle("Acuerdo 1");
        agreement1.setDescription("Descripción 1 mínimo de 20 carácteres");
        agreement1.setAboutMe("Sobre mi 1");
        agreement1.setPlaces(Arrays.asList(EPlace.ONLINE,EPlace.IN_PERSON));
        agreement1.setLanguages(Arrays.asList(l1,l2));

        agreementRepositoryJpa.save(agreement1);

        pack1.setRate(rate1);
        agreement1.setRate(rate1);
        agreementRepositoryJpa.save(agreement1);



        AgreementInputDto agreementInputDto2 = new AgreementInputDto();
        agreementInputDto2.setTitle("Acuerdo 1");
        agreementInputDto2.setDescription("Descripción 1 mínimo de 20 carácteres");
        agreementInputDto2.setAboutMe("Sobre mi 1");
        agreementInputDto2.setPlaces(Arrays.asList(EPlace.ONLINE,EPlace.IN_PERSON));
        agreementInputDto2.setIdsLanguages(Arrays.asList(1L,2L));

        RateInputDto rateInputDto1 = new RateInputDto();
        rateInputDto1.setPricePerHour(5.0);

        PackInputDto packInputDto1 = new PackInputDto();
        packInputDto1.setHours("10");
        packInputDto1.setPrice(50.0);
        PackInputDto packInputDto2 = new PackInputDto();
        packInputDto2.setHours("20");
        packInputDto2.setPrice(110.0);

        rateInputDto1.setPacks(Arrays.asList(packInputDto1, packInputDto2));

        agreementInputDto2.setRate(rateInputDto1);

        var createAgreementUseCase = context.getBean(CreateAgreementUseCase.class);
        createAgreementUseCase.save(agreementInputDto2);
    */
        /*
        Agreement agreement2 = AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto2);
        AgreementJpa agreementJpa2 = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement2);

        agreementRepositoryJpa.save(agreementJpa2);
*/

/*
        var rateJpaRepository = context.getBean(RateRepositoryJpa.class);

// Create and set up AgreementInputDto
        AgreementInputDto agreementInputDto = new AgreementInputDto();
        agreementInputDto.setTitle("Acuerdo 2");
        agreementInputDto.setDescription("Descripción 2 mínimo de 20 carácteres");
        agreementInputDto.setAboutMe("Sobre mi 2");
        agreementInputDto.setPlaces(Arrays.asList(EPlace.ONLINE, EPlace.IN_PERSON));
        agreementInputDto.setIdsLanguages(Arrays.asList(1L, 2L));

// Map AgreementInputDto to Agreement entity and then to AgreementJpa
        Agreement agreement2 = AgreementEntityMapper.INSTANCE.toEntity(agreementInputDto);
        AgreementJpa agreementJpa2 = AgreementEntityMapper.INSTANCE.toEntityJpa(agreement2);

// Save the AgreementJpa entity
        agreementRepositoryJpa.save(agreementJpa2);

// Create and set up PackInputDto
        PackInputDto packInputDto1 = new PackInputDto();
        packInputDto1.setHours("10");
        packInputDto1.setPrice(50.0);

// Create and set up RateInputDto with the PackInputDto
        RateInputDto rateInputDto1 = new RateInputDto();
        rateInputDto1.setPricePerHour(5.0);
        rateInputDto1.setPacks(List.of(packInputDto1));

// Map PackInputDto to Pack entity
        Pack pack2 = PackMapper.INSTANCE.toEntity(packInputDto1);
        PackJpa packJpa2 = PackMapper.INSTANCE.toEntityJpa(pack2);

// Map RateInputDto to Rate entity and then to RateJpa
        Rate rate2 = RateMapper.INSTANCE.toEntity(rateInputDto1);
        RateJpa rateJpa2 = RateMapper.INSTANCE.toEntityJpa(rate2);

// Save the RateJpa entity
        rateJpa2.setPacks(List.of(packJpa2));
        packJpa2.setRate(rateJpa2);
        rateJpaRepository.save(rateJpa2);

// Retrieve the saved AgreementJpa entity
        AgreementJpa agreementJpa3 = agreementRepositoryJpa.findById(agreementJpa2.getIdAgreement()).orElseThrow(
                () -> new RuntimeException("No se ha encontrado el acuerdo")
        );

// Associate the saved RateJpa entity with the AgreementJpa entity
        agreementJpa3.setRate(rateJpa2);

// Save the updated AgreementJpa entity
        agreementRepositoryJpa.save(agreementJpa3);




        var createAgreementUseCase = context.getBean(CreateAgreementUseCase.class);

        PackInputDto newPackInputDto = new PackInputDto();
        newPackInputDto.setHours("20");
        newPackInputDto.setPrice(100.0);

        Pack newPack = PackMapper.INSTANCE.toEntity(newPackInputDto);

        createAgreementUseCase.addNewPackToAgreementRate(2L, newPack);
*/
    }

}
