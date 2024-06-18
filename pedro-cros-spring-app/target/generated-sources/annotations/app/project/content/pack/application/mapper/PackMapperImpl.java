package app.project.content.pack.application.mapper;

import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T22:45:12+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PackMapperImpl implements PackMapper {

    @Override
    public Pack toEntity(PackInputDto packInputDto) {
        if ( packInputDto == null ) {
            return null;
        }

        Pack pack = new Pack();

        pack.setHours( packInputDto.getHours() );
        pack.setPrice( packInputDto.getPrice() );

        return pack;
    }

    @Override
    public Pack toEntity(PackJpa packJpa) {
        if ( packJpa == null ) {
            return null;
        }

        Pack pack = new Pack();

        pack.setIdPack( packJpa.getIdPack() );
        pack.setHours( packJpa.getHours() );
        pack.setPrice( packJpa.getPrice() );

        return pack;
    }

    @Override
    public PackJpa toEntityJpa(Pack pack) {
        if ( pack == null ) {
            return null;
        }

        PackJpa packJpa = new PackJpa();

        packJpa.setIdPack( pack.getIdPack() );
        packJpa.setHours( pack.getHours() );
        packJpa.setPrice( pack.getPrice() );

        return packJpa;
    }

    @Override
    public PackOutputDtoFull toOutputDto(Pack pack) {
        if ( pack == null ) {
            return null;
        }

        PackOutputDtoFull packOutputDtoFull = new PackOutputDtoFull();

        packOutputDtoFull.setIdPack( pack.getIdPack() );
        packOutputDtoFull.setHours( pack.getHours() );
        packOutputDtoFull.setPrice( pack.getPrice() );

        return packOutputDtoFull;
    }

    @Override
    public List<PackOutputDtoFull> toOutputDtoList(List<Pack> packList) {
        if ( packList == null ) {
            return null;
        }

        List<PackOutputDtoFull> list = new ArrayList<PackOutputDtoFull>( packList.size() );
        for ( Pack pack : packList ) {
            list.add( toOutputDto( pack ) );
        }

        return list;
    }
}
