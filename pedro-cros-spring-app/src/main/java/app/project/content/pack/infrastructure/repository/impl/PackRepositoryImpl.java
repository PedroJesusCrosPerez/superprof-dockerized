package app.project.content.pack.infrastructure.repository.impl;

import app.project.content.pack.application.mapper.PackMapper;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.domain.repository.PackRepository;
import app.project.content.pack.infrastructure.repository.jpa.PackRepositoryJpa;
import app.project.content.pack.infrastructure.repository.jpa.entity.PackJpa;
import app.project.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PackRepositoryImpl implements PackRepository {

    private final PackRepositoryJpa packRepositoryJpa;


    @Override
    public Long save(Pack pack) {

        PackJpa packJpa = PackMapper.INSTANCE.toEntityJpa(pack);
//        packJpa.setIdRate(pack.getRate().getIdRate());

        return packRepositoryJpa.save(packJpa).getIdPack();
    }

    @Override
    public Pack findById(Long idPack) {

        return packRepositoryJpa.findById(idPack)
                .map(PackMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new NotFoundException(Pack.class, idPack)
                );
    }

    @Override
    public List<Pack> findAll() {

        return packRepositoryJpa.findAll().stream()
                .map(PackMapper.INSTANCE::toEntity)
                .toList();
    }

    @Override
    public Boolean delete(Long idPack) {

        packRepositoryJpa.deleteById(idPack);

        return true;
    }

    @Override
    public Pack update(Pack pack) {

        throw new RuntimeException("Not implemented yet");
    }
}
