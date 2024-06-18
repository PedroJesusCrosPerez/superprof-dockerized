package app.project.content.rate.application.impl;

import app.project.content.pack.application.PackUseCase;
import app.project.content.pack.domain.entity.Pack;
import app.project.content.pack.infrastructure.repository.jpa.PackRepositoryJpa;
import app.project.content.rate.application.RateUseCase;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.domain.repository.RateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateUseCaseImpl implements RateUseCase {

    // Rate repo
    private final RateRepository rateRepository;
        // Dependencies =>
    private final PackUseCase packUseCase;
    private final PackRepositoryJpa packRepositoryJpa;

    @Override
//    @Transactional
//    public Long save(Rate rate) {
    public Rate save(Rate rate) {

        Long idRateNew = rateRepository.save(rate);
        rate.setIdRate(idRateNew);

        for (Pack pack : rate.getPacks()) {
//            pack.setRate(rate);
//            packUseCase.save(pack);
            rate.addPack(pack);
        }

//        return idRateNew;
        return rate;
    }

    @Override
    @Transactional
    public Rate addPack(Pack pack, Rate rate) {

//        rate.addPack(pack);

        return rateRepository.update(rate, pack);
    }

    @Override
    public Rate findById(Long idRate) {

        return rateRepository.findById(idRate);
    }

    @Override
    public List<Rate> findAll() {

        return rateRepository.findAll();
    }

    @Override
    public Rate update(Rate rate) {

//        return rateRepository.update(rate);
        return new Rate();
    }

    @Override
    public Boolean delete(Long idRate) {

        return rateRepository.delete(idRate);
    }
}
