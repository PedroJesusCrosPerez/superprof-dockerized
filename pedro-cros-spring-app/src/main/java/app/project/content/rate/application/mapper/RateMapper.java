package app.project.content.rate.application.mapper;

import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.infrastructure.controller.dto.input.RateInputDto;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDto;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RateMapper {

    RateMapper INSTANCE = Mappers.getMapper(RateMapper.class);

    // Entity
//    @Mapping(target = "packs", ignore = true)
    Rate toEntity(RateInputDto rateInputDto);

    Rate toEntity(RateJpa rateJpa);


    // Entity Jpa
    RateJpa toEntityJpa(Rate rate);


    // OutputDto
    RateOutputDto toOutputDto(Rate rate);

    List<RateOutputDto> toOutputDtoList(List<Rate> rateList);
}
