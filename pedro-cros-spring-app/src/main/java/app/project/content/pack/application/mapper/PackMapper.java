package app.project.content.pack.application.mapper;

import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PackMapper {

    PackMapper INSTANCE = Mappers.getMapper(PackMapper.class);

    // Entity
    Pack toEntity(PackInputDto packInputDto);

    Pack toEntity(PackJpa packJpa);


    // Entity Jpa
//    @Mapping(target = "idRate", ignore = true)
    PackJpa toEntityJpa(Pack pack);


    // OutputDto
    PackOutputDtoFull toOutputDto(Pack pack);

    List<PackOutputDtoFull> toOutputDtoList(List<Pack> packList);
}
