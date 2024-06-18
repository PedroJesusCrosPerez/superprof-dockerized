package app.project.content.rate.application;

import app.project.content.pack.domain.entity.Pack;
import app.project.content.rate.domain.entity.Rate;

import java.util.List;

public interface RateUseCase {

//    Long save(Rate rate);
    Rate save(Rate rate);

    Rate addPack(Pack pack, Rate rate);

    Rate findById(Long idRate);

    List<Rate> findAll();

    Rate update(Rate rate);

    Boolean delete(Long idRate);
}
