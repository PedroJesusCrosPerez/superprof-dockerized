package app.project.content.language.application.mapper;

import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.language.infrastructure.controller.dto.input.LanguageUpdateInputDto;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDtoFull;
import app.project.content.language.infrastructure.repository.jpa.entity.LanguageJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);


    // Entity
    Language toEntity(LanguageInputDto languageInputDto);

    Language toEntity(LanguageUpdateInputDto languageUpdateInputDto);

    Language toEntity(LanguageJpa languageJpa);

    List<Language> toEntityList(List<LanguageJpa> languageJpaList);


    // Entity Jpa
    LanguageJpa toEntityJpa(Language language);

    List<LanguageJpa> toEntityJpaList(List<Language> languageList);


    // OutputDto
    LanguageOutputDtoFull toOutputDto(Language language);

    List<LanguageOutputDtoFull> toOutputDtoList(List<Language> languageList);
}
