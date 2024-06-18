package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.RetrieveSubjectUsecase;
import app.project.content.subject.application.mapper.SubjectDtoMapper;
import app.project.content.subject.domain.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class RetrieveSubjectRestController {

    private final RetrieveSubjectUsecase retrieveSubjectUseCase;


    @GetMapping("/{idSubject}")
    public ResponseEntity<?> findByIdSubject(
            @PathVariable Long idSubject
            ,@RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        Subject subject = retrieveSubjectUseCase.findByIdSubject(idSubject);

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectDtoMapper.INSTANCE.toOutputDtoFull(
                                    subject
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectDtoMapper.INSTANCE.toOutputDto(
                                subject
                        )
                );
    }

    @GetMapping
    public ResponseEntity<?> findAllSubjects(
            @RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        List<Subject> subjectList = retrieveSubjectUseCase.findAllSubjects();

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            SubjectDtoMapper.INSTANCE.toOutputDtoFullList(
                                    subjectList
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        SubjectDtoMapper.INSTANCE.toOutputDtoList(
                                subjectList
                        )
                );
    }
}
