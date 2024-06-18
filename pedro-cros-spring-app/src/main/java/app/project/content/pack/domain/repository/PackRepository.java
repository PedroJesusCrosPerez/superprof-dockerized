package app.project.content.pack.domain.repository;

import app.project.content.pack.domain.entity.Pack;

import java.util.List;

public interface PackRepository {

    Long save(Pack pack);
    Pack findById(Long idPack);
    List<Pack> findAll();
    Boolean delete(Long idPack);
    Pack update(Pack pack);
}
