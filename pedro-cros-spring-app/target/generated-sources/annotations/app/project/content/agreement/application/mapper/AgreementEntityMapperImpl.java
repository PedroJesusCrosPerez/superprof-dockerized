package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementInputDto;
import app.project.content.agreement.infrastructure.controller.dto.input.AgreementUpdateInputDto;
import app.project.content.agreement.infrastructure.repository.jpa.entity.AgreementJpa;
import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.infrastructure.controller.dto.input.RateInputDto;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.shared.enums.EPlace;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T21:57:53+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AgreementEntityMapperImpl implements AgreementEntityMapper {

    @Override
    public Agreement toEntity(AgreementInputDto agreementInputDto) {
        if ( agreementInputDto == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setTitle( agreementInputDto.getTitle() );
        agreement.setDescription( agreementInputDto.getDescription() );
        agreement.setAboutMe( agreementInputDto.getAboutMe() );
        agreement.setIsActive( agreementInputDto.getIsActive() );
        List<EPlace> list = agreementInputDto.getPlaces();
        if ( list != null ) {
            agreement.setPlaces( new ArrayList<EPlace>( list ) );
        }
        agreement.setRate( rateInputDtoToRate( agreementInputDto.getRate() ) );

        return agreement;
    }

    @Override
    public Agreement toEntity(AgreementUpdateInputDto agreementUpdateInputDto) {
        if ( agreementUpdateInputDto == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setIdAgreement( agreementUpdateInputDto.getIdAgreement() );
        agreement.setTitle( agreementUpdateInputDto.getTitle() );
        agreement.setDescription( agreementUpdateInputDto.getDescription() );
        agreement.setAboutMe( agreementUpdateInputDto.getAboutMe() );
        List<EPlace> list = agreementUpdateInputDto.getPlaces();
        if ( list != null ) {
            agreement.setPlaces( new ArrayList<EPlace>( list ) );
        }
        agreement.setLanguages( languageInputDtoListToLanguageList( agreementUpdateInputDto.getLanguages() ) );
        agreement.setRate( rateInputDtoToRate( agreementUpdateInputDto.getRate() ) );

        return agreement;
    }

    @Override
    public Agreement toEntity(AgreementJpa agreementJpa) {
        if ( agreementJpa == null ) {
            return null;
        }

        Agreement agreement = new Agreement();

        agreement.setIdAgreement( agreementJpa.getIdAgreement() );
        agreement.setTitle( agreementJpa.getTitle() );
        agreement.setDescription( agreementJpa.getDescription() );
        agreement.setAboutMe( agreementJpa.getAboutMe() );
        agreement.setIsActive( agreementJpa.getIsActive() );
        agreement.setSubjects( subjectJpaListToSubjectList( agreementJpa.getSubjects() ) );
        List<EPlace> list1 = agreementJpa.getPlaces();
        if ( list1 != null ) {
            agreement.setPlaces( new ArrayList<EPlace>( list1 ) );
        }
        agreement.setLanguages( languageJpaListToLanguageList( agreementJpa.getLanguages() ) );
        agreement.setRate( rateJpaToRate( agreementJpa.getRate() ) );

        return agreement;
    }

    @Override
    public AgreementJpa toEntityJpa(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementJpa agreementJpa = new AgreementJpa();

        agreementJpa.setIdAgreement( agreement.getIdAgreement() );
        agreementJpa.setTitle( agreement.getTitle() );
        agreementJpa.setDescription( agreement.getDescription() );
        agreementJpa.setAboutMe( agreement.getAboutMe() );
        agreementJpa.setIsActive( agreement.getIsActive() );
        agreementJpa.setSubjects( subjectListToSubjectJpaList( agreement.getSubjects() ) );
        List<EPlace> list1 = agreement.getPlaces();
        if ( list1 != null ) {
            agreementJpa.setPlaces( new ArrayList<EPlace>( list1 ) );
        }
        agreementJpa.setLanguages( languageListToLanguageJpaList( agreement.getLanguages() ) );
        agreementJpa.setRate( rateToRateJpa( agreement.getRate() ) );

        return agreementJpa;
    }

    protected Pack packInputDtoToPack(PackInputDto packInputDto) {
        if ( packInputDto == null ) {
            return null;
        }

        Pack pack = new Pack();

        pack.setHours( packInputDto.getHours() );
        pack.setPrice( packInputDto.getPrice() );

        return pack;
    }

    protected List<Pack> packInputDtoListToPackList(List<PackInputDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Pack> list1 = new ArrayList<Pack>( list.size() );
        for ( PackInputDto packInputDto : list ) {
            list1.add( packInputDtoToPack( packInputDto ) );
        }

        return list1;
    }

    protected Rate rateInputDtoToRate(RateInputDto rateInputDto) {
        if ( rateInputDto == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setPricePerHour( rateInputDto.getPricePerHour() );
        rate.setPacks( packInputDtoListToPackList( rateInputDto.getPacks() ) );

        return rate;
    }

    protected Language languageInputDtoToLanguage(LanguageInputDto languageInputDto) {
        if ( languageInputDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( languageInputDto.getName() );
        language.setCode( languageInputDto.getCode() );

        return language;
    }

    protected List<Language> languageInputDtoListToLanguageList(List<LanguageInputDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Language> list1 = new ArrayList<Language>( list.size() );
        for ( LanguageInputDto languageInputDto : list ) {
            list1.add( languageInputDtoToLanguage( languageInputDto ) );
        }

        return list1;
    }

    protected Subject subjectJpaToSubject(SubjectJpa subjectJpa) {
        if ( subjectJpa == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setIdSubject( subjectJpa.getIdSubject() );
        subject.setName( subjectJpa.getName() );

        return subject;
    }

    protected List<Subject> subjectJpaListToSubjectList(List<SubjectJpa> list) {
        if ( list == null ) {
            return null;
        }

        List<Subject> list1 = new ArrayList<Subject>( list.size() );
        for ( SubjectJpa subjectJpa : list ) {
            list1.add( subjectJpaToSubject( subjectJpa ) );
        }

        return list1;
    }

    protected Language languageJpaToLanguage(LanguageJpa languageJpa) {
        if ( languageJpa == null ) {
            return null;
        }

        Language language = new Language();

        language.setIdLanguage( languageJpa.getIdLanguage() );
        language.setName( languageJpa.getName() );
        language.setCode( languageJpa.getCode() );

        return language;
    }

    protected List<Language> languageJpaListToLanguageList(List<LanguageJpa> list) {
        if ( list == null ) {
            return null;
        }

        List<Language> list1 = new ArrayList<Language>( list.size() );
        for ( LanguageJpa languageJpa : list ) {
            list1.add( languageJpaToLanguage( languageJpa ) );
        }

        return list1;
    }

    protected Pack packJpaToPack(PackJpa packJpa) {
        if ( packJpa == null ) {
            return null;
        }

        Pack pack = new Pack();

        pack.setIdPack( packJpa.getIdPack() );
        pack.setHours( packJpa.getHours() );
        pack.setPrice( packJpa.getPrice() );

        return pack;
    }

    protected List<Pack> packJpaListToPackList(List<PackJpa> list) {
        if ( list == null ) {
            return null;
        }

        List<Pack> list1 = new ArrayList<Pack>( list.size() );
        for ( PackJpa packJpa : list ) {
            list1.add( packJpaToPack( packJpa ) );
        }

        return list1;
    }

    protected Rate rateJpaToRate(RateJpa rateJpa) {
        if ( rateJpa == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setIdRate( rateJpa.getIdRate() );
        rate.setPricePerHour( rateJpa.getPricePerHour() );
        rate.setPacks( packJpaListToPackList( rateJpa.getPacks() ) );

        return rate;
    }

    protected SubjectJpa subjectToSubjectJpa(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectJpa subjectJpa = new SubjectJpa();

        subjectJpa.setIdSubject( subject.getIdSubject() );
        subjectJpa.setName( subject.getName() );

        return subjectJpa;
    }

    protected List<SubjectJpa> subjectListToSubjectJpaList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectJpa> list1 = new ArrayList<SubjectJpa>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectToSubjectJpa( subject ) );
        }

        return list1;
    }

    protected LanguageJpa languageToLanguageJpa(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageJpa languageJpa = new LanguageJpa();

        languageJpa.setIdLanguage( language.getIdLanguage() );
        languageJpa.setName( language.getName() );
        languageJpa.setCode( language.getCode() );

        return languageJpa;
    }

    protected List<LanguageJpa> languageListToLanguageJpaList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageJpa> list1 = new ArrayList<LanguageJpa>( list.size() );
        for ( Language language : list ) {
            list1.add( languageToLanguageJpa( language ) );
        }

        return list1;
    }

    protected PackJpa packToPackJpa(Pack pack) {
        if ( pack == null ) {
            return null;
        }

        PackJpa packJpa = new PackJpa();

        packJpa.setIdPack( pack.getIdPack() );
        packJpa.setHours( pack.getHours() );
        packJpa.setPrice( pack.getPrice() );

        return packJpa;
    }

    protected List<PackJpa> packListToPackJpaList(List<Pack> list) {
        if ( list == null ) {
            return null;
        }

        List<PackJpa> list1 = new ArrayList<PackJpa>( list.size() );
        for ( Pack pack : list ) {
            list1.add( packToPackJpa( pack ) );
        }

        return list1;
    }

    protected RateJpa rateToRateJpa(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateJpa rateJpa = new RateJpa();

        rateJpa.setIdRate( rate.getIdRate() );
        rateJpa.setPricePerHour( rate.getPricePerHour() );
        rateJpa.setPacks( packListToPackJpaList( rate.getPacks() ) );

        return rateJpa;
    }
}
