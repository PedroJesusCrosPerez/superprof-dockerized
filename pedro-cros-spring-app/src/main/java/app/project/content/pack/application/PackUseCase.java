package app.project.content.pack.application;

import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;

import java.util.List;

public interface PackUseCase {

    Long save(PackInputDto packInputDto);
    Pack findById(Long idPack);
    List<Pack> findByRateId(Long idPack);
    List<PackOutputDtoFull> getPacks();
//    Pack updatePack(PackInputDto packInputDto);
//    Boolean deletePack(Long idPack);
}
