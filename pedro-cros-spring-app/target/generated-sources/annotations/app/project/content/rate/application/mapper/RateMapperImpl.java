package app.project.content.rate.application.mapper;

import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.infrastructure.controller.dto.input.RateInputDto;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDto;
import app.project.content.rate.infrastructure.repository.jpa.entity.RateJpa;
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
public class RateMapperImpl implements RateMapper {

    @Override
    public Rate toEntity(RateInputDto rateInputDto) {
        if ( rateInputDto == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setPricePerHour( rateInputDto.getPricePerHour() );
        rate.setPacks( packInputDtoListToPackList( rateInputDto.getPacks() ) );

        return rate;
    }

    @Override
    public Rate toEntity(RateJpa rateJpa) {
        if ( rateJpa == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setIdRate( rateJpa.getIdRate() );
        rate.setPricePerHour( rateJpa.getPricePerHour() );
        rate.setPacks( packJpaListToPackList( rateJpa.getPacks() ) );

        return rate;
    }

    @Override
    public RateJpa toEntityJpa(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateJpa rateJpa = new RateJpa();

        rateJpa.setIdRate( rate.getIdRate() );
        rateJpa.setPricePerHour( rate.getPricePerHour() );
        rateJpa.setPacks( packListToPackJpaList( rate.getPacks() ) );

        return rateJpa;
    }

    @Override
    public RateOutputDto toOutputDto(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RateOutputDto rateOutputDto = new RateOutputDto();

        rateOutputDto.setIdRate( rate.getIdRate() );

        return rateOutputDto;
    }

    @Override
    public List<RateOutputDto> toOutputDtoList(List<Rate> rateList) {
        if ( rateList == null ) {
            return null;
        }

        List<RateOutputDto> list = new ArrayList<RateOutputDto>( rateList.size() );
        for ( Rate rate : rateList ) {
            list.add( toOutputDto( rate ) );
        }

        return list;
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
}
