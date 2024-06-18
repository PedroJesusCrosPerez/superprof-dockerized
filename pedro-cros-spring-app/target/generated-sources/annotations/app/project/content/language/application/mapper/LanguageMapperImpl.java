package app.project.content.language.application.mapper;

import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.language.infrastructure.controller.dto.input.LanguageUpdateInputDto;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDtoFull;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
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
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public Language toEntity(LanguageInputDto languageInputDto) {
        if ( languageInputDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( languageInputDto.getName() );
        language.setCode( languageInputDto.getCode() );

        return language;
    }

    @Override
    public Language toEntity(LanguageUpdateInputDto languageUpdateInputDto) {
        if ( languageUpdateInputDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setIdLanguage( languageUpdateInputDto.getIdLanguage() );
        language.setName( languageUpdateInputDto.getName() );
        language.setCode( languageUpdateInputDto.getCode() );

        return language;
    }

    @Override
    public Language toEntity(LanguageJpa languageJpa) {
        if ( languageJpa == null ) {
            return null;
        }

        Language language = new Language();

        language.setIdLanguage( languageJpa.getIdLanguage() );
        language.setName( languageJpa.getName() );
        language.setCode( languageJpa.getCode() );

        return language;
    }

    @Override
    public List<Language> toEntityList(List<LanguageJpa> languageJpaList) {
        if ( languageJpaList == null ) {
            return null;
        }

        List<Language> list = new ArrayList<Language>( languageJpaList.size() );
        for ( LanguageJpa languageJpa : languageJpaList ) {
            list.add( toEntity( languageJpa ) );
        }

        return list;
    }

    @Override
    public LanguageJpa toEntityJpa(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageJpa languageJpa = new LanguageJpa();

        languageJpa.setIdLanguage( language.getIdLanguage() );
        languageJpa.setName( language.getName() );
        languageJpa.setCode( language.getCode() );

        return languageJpa;
    }

    @Override
    public List<LanguageJpa> toEntityJpaList(List<Language> languageList) {
        if ( languageList == null ) {
            return null;
        }

        List<LanguageJpa> list = new ArrayList<LanguageJpa>( languageList.size() );
        for ( Language language : languageList ) {
            list.add( toEntityJpa( language ) );
        }

        return list;
    }

    @Override
    public LanguageOutputDtoFull toOutputDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageOutputDtoFull languageOutputDtoFull = new LanguageOutputDtoFull();

        languageOutputDtoFull.setIdLanguage( language.getIdLanguage() );
        languageOutputDtoFull.setName( language.getName() );
        languageOutputDtoFull.setCode( language.getCode() );

        return languageOutputDtoFull;
    }

    @Override
    public List<LanguageOutputDtoFull> toOutputDtoList(List<Language> languageList) {
        if ( languageList == null ) {
            return null;
        }

        List<LanguageOutputDtoFull> list = new ArrayList<LanguageOutputDtoFull>( languageList.size() );
        for ( Language language : languageList ) {
            list.add( toOutputDto( language ) );
        }

        return list;
    }
}
