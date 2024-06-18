package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFull;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDto;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDtoFull;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDto;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDtoFull;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import app.project.shared.enums.EPlace;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T21:57:54+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AgreementDtoMapperImpl implements AgreementDtoMapper {

    @Override
    public AgreementOutputDto toOutputDto(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementOutputDto agreementOutputDto = new AgreementOutputDto();

        agreementOutputDto.setIdAgreement( agreement.getIdAgreement() );
        agreementOutputDto.setTitle( agreement.getTitle() );
        List<EPlace> list = agreement.getPlaces();
        if ( list != null ) {
            agreementOutputDto.setPlaces( new ArrayList<EPlace>( list ) );
        }
        agreementOutputDto.setLanguages( languageListToLanguageOutputDtoList( agreement.getLanguages() ) );
        agreementOutputDto.setRate( rateToRateOutputDto( agreement.getRate() ) );

        return agreementOutputDto;
    }

    @Override
    public List<AgreementOutputDto> toOutputDtoList(List<Agreement> agreementList) {
        if ( agreementList == null ) {
            return null;
        }

        List<AgreementOutputDto> list = new ArrayList<AgreementOutputDto>( agreementList.size() );
        for ( Agreement agreement : agreementList ) {
            list.add( toOutputDto( agreement ) );
        }

        return list;
    }

    @Override
    public AgreementOutputDtoFull toOutputDtoFull(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementOutputDtoFull agreementOutputDtoFull = new AgreementOutputDtoFull();

        agreementOutputDtoFull.setIdAgreement( agreement.getIdAgreement() );
        agreementOutputDtoFull.setTitle( agreement.getTitle() );
        agreementOutputDtoFull.setDescription( agreement.getDescription() );
        agreementOutputDtoFull.setAboutMe( agreement.getAboutMe() );
        agreementOutputDtoFull.setIsActive( agreement.getIsActive() );
        agreementOutputDtoFull.setSubjects( subjectListToSubjectOutputDtoFullList( agreement.getSubjects() ) );
        List<EPlace> list1 = agreement.getPlaces();
        if ( list1 != null ) {
            agreementOutputDtoFull.setPlaces( new ArrayList<EPlace>( list1 ) );
        }
        agreementOutputDtoFull.setLanguages( languageListToLanguageOutputDtoFullList( agreement.getLanguages() ) );
        agreementOutputDtoFull.setRate( rateToRateOutputDtoFull( agreement.getRate() ) );

        return agreementOutputDtoFull;
    }

    @Override
    public AgreementOutputDtoFullOneSubject toOutputDtoFullOneSubject(Agreement agreement) {
        if ( agreement == null ) {
            return null;
        }

        AgreementOutputDtoFullOneSubject agreementOutputDtoFullOneSubject = new AgreementOutputDtoFullOneSubject();

        agreementOutputDtoFullOneSubject.setSubject( firstSubjectToDto( agreement.getSubjects() ) );
        agreementOutputDtoFullOneSubject.setIdAgreement( agreement.getIdAgreement() );
        agreementOutputDtoFullOneSubject.setTitle( agreement.getTitle() );
        agreementOutputDtoFullOneSubject.setDescription( agreement.getDescription() );
        agreementOutputDtoFullOneSubject.setAboutMe( agreement.getAboutMe() );
        agreementOutputDtoFullOneSubject.setIsActive( agreement.getIsActive() );
        List<EPlace> list = agreement.getPlaces();
        if ( list != null ) {
            agreementOutputDtoFullOneSubject.setPlaces( new ArrayList<EPlace>( list ) );
        }
        agreementOutputDtoFullOneSubject.setLanguages( languageListToLanguageOutputDtoFullList( agreement.getLanguages() ) );
        agreementOutputDtoFullOneSubject.setRate( rateToRateOutputDtoFull( agreement.getRate() ) );

        return agreementOutputDtoFullOneSubject;
    }

    @Override
    public List<AgreementOutputDtoFull> toOutputDtoListFull(List<Agreement> agreement) {
        if ( agreement == null ) {
            return null;
        }

        List<AgreementOutputDtoFull> list = new ArrayList<AgreementOutputDtoFull>( agreement.size() );
        for ( Agreement agreement1 : agreement ) {
            list.add( toOutputDtoFull( agreement1 ) );
        }

        return list;
    }

    protected LanguageOutputDto languageToLanguageOutputDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageOutputDto languageOutputDto = new LanguageOutputDto();

        languageOutputDto.setName( language.getName() );

        return languageOutputDto;
    }

    protected List<LanguageOutputDto> languageListToLanguageOutputDtoList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageOutputDto> list1 = new ArrayList<LanguageOutputDto>( list.size() );
        for ( Language language : list ) {
            list1.add( languageToLanguageOutputDto( language ) );
        }

        return list1;
    }

    protected RateOutputDto rateToRateOutputDto(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateOutputDto rateOutputDto = new RateOutputDto();

        rateOutputDto.setIdRate( rate.getIdRate() );

        return rateOutputDto;
    }

    protected SubjectOutputDtoFull subjectToSubjectOutputDtoFull(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectOutputDtoFull subjectOutputDtoFull = new SubjectOutputDtoFull();

        subjectOutputDtoFull.setIdSubject( subject.getIdSubject() );
        subjectOutputDtoFull.setName( subject.getName() );

        return subjectOutputDtoFull;
    }

    protected List<SubjectOutputDtoFull> subjectListToSubjectOutputDtoFullList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectOutputDtoFull> list1 = new ArrayList<SubjectOutputDtoFull>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectToSubjectOutputDtoFull( subject ) );
        }

        return list1;
    }

    protected LanguageOutputDtoFull languageToLanguageOutputDtoFull(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageOutputDtoFull languageOutputDtoFull = new LanguageOutputDtoFull();

        languageOutputDtoFull.setIdLanguage( language.getIdLanguage() );
        languageOutputDtoFull.setName( language.getName() );
        languageOutputDtoFull.setCode( language.getCode() );

        return languageOutputDtoFull;
    }

    protected List<LanguageOutputDtoFull> languageListToLanguageOutputDtoFullList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageOutputDtoFull> list1 = new ArrayList<LanguageOutputDtoFull>( list.size() );
        for ( Language language : list ) {
            list1.add( languageToLanguageOutputDtoFull( language ) );
        }

        return list1;
    }

    protected PackOutputDtoFull packToPackOutputDtoFull(Pack pack) {
        if ( pack == null ) {
            return null;
        }

        PackOutputDtoFull packOutputDtoFull = new PackOutputDtoFull();

        packOutputDtoFull.setIdPack( pack.getIdPack() );
        packOutputDtoFull.setHours( pack.getHours() );
        packOutputDtoFull.setPrice( pack.getPrice() );

        return packOutputDtoFull;
    }

    protected List<PackOutputDtoFull> packListToPackOutputDtoFullList(List<Pack> list) {
        if ( list == null ) {
            return null;
        }

        List<PackOutputDtoFull> list1 = new ArrayList<PackOutputDtoFull>( list.size() );
        for ( Pack pack : list ) {
            list1.add( packToPackOutputDtoFull( pack ) );
        }

        return list1;
    }

    protected RateOutputDtoFull rateToRateOutputDtoFull(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateOutputDtoFull rateOutputDtoFull = new RateOutputDtoFull();

        rateOutputDtoFull.setIdRate( rate.getIdRate() );
        rateOutputDtoFull.setPricePerHour( rate.getPricePerHour() );
        rateOutputDtoFull.setPacks( packListToPackOutputDtoFullList( rate.getPacks() ) );

        return rateOutputDtoFull;
    }
}
