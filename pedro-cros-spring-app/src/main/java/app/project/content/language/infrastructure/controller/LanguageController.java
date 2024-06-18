package app.project.content.language.infrastructure.controller;

import app.project.content.language.application.LanguageUseCase;
import app.project.content.language.application.mapper.LanguageMapper;
import app.project.content.language.domain.entity.Language;
import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.language.infrastructure.controller.dto.input.LanguageUpdateInputDto;
import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDtoFull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageUseCase languageUseCase;


    @GetMapping("/{idLanguage}")
    public ResponseEntity<LanguageOutputDtoFull> findById(@PathVariable Long idLanguage) {

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        LanguageMapper.INSTANCE.toOutputDto(
                                languageUseCase.findById(idLanguage)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<List<LanguageOutputDtoFull>> findAll() {

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        LanguageMapper.INSTANCE.toOutputDtoList(
                                languageUseCase.findAll()
                        )
                );
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody LanguageInputDto languageInputDto) {

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        languageUseCase.save(
                                LanguageMapper.INSTANCE.toEntity(languageInputDto)
                        )
                );
    }

    @PutMapping
    public ResponseEntity<Language> update(@RequestBody LanguageUpdateInputDto languageUpdateInputDto) {

        return  ResponseEntity
                .status(
//                        HttpStatus.ACCEPTED
                        HttpStatus.NOT_IMPLEMENTED
                )
                .body(
                        languageUseCase.update(
                                LanguageMapper.INSTANCE.toEntity(languageUpdateInputDto)
                        )
                );
    }

    @DeleteMapping("/{idLanguage}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idLanguage) {

        return  ResponseEntity
                .status(
//                        HttpStatus.NO_CONTENT
                        HttpStatus.NOT_IMPLEMENTED
                )
                .body(
                        languageUseCase.delete(idLanguage)
                );
    }
}
