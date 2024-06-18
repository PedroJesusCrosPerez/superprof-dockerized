package app.project.content.rate.infrastructure.controller;

import app.project.content.rate.application.RateUseCase;
import app.project.content.rate.application.mapper.RateMapper;
import app.project.content.rate.domain.entity.Rate;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rates")
@RequiredArgsConstructor
public class RateRestController {

    private final RateUseCase rateUseCase;


    @GetMapping
    public ResponseEntity<List<RateOutputDto>> findAll() {

        List<RateOutputDto> rates = rateUseCase.findAll().stream()
                .map(RateMapper.INSTANCE::toOutputDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(rates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RateOutputDto> findById(@PathVariable Long id) {

        RateOutputDto rate = RateMapper.INSTANCE.toOutputDto(rateUseCase.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(rate);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Rate rate) {

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        rateUseCase.save(rate).getIdRate()
                );
    }

    @PutMapping
    public ResponseEntity<RateOutputDto> update(@RequestBody Rate rate) {

        RateOutputDto updatedRate = RateMapper.INSTANCE.toOutputDto(rateUseCase.update(rate));
        return ResponseEntity.status(HttpStatus.OK).body(updatedRate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(rateUseCase.delete(id));
    }
}
