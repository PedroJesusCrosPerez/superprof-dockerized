package app.project.content.pack.application.impl;

import app.project.content.pack.application.PackUseCase;
import app.project.content.pack.application.mapper.PackMapper;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.domain.repository.PackRepository;
import app.project.content.pack.infrastructure.controller.dto.input.PackInputDto;
import app.project.content.pack.infrastructure.controller.dto.output.PackOutputDtoFull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PackUseCaseImpl implements PackUseCase {

    // Pack repo
    private final PackRepository packRepository;


    @Override
    public Long save(PackInputDto packInputDto) {

        return packRepository.save(
                PackMapper.INSTANCE.toEntity(packInputDto)
        );
    }

    @Override
    public List<PackOutputDtoFull> getPacks() {

        return packRepository.findAll().stream()
                .map(PackMapper.INSTANCE::toOutputDto)
                .toList();
    }

    @Override
    public Pack findById(Long idPack) {

        return packRepository.findById(idPack);
    }

    @Override
    public List<Pack> findByRateId(Long idPack) {

        throw new RuntimeException("Not implemented yet");
    }
}
