package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.CreateSubjectUseCase;
import app.project.content.subject.application.mapper.SubjectEntityMapper;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class CreateSubjectRestController {

    private final CreateSubjectUseCase createSubjectUseCase;


    @PostMapping
    public ResponseEntity<Long> saveSubject(
            @RequestBody SubjectInputDto subjectInputDto
    ) {

        Long idSubject = createSubjectUseCase.saveSubject(
                SubjectEntityMapper.INSTANCE.toEntity(
                        subjectInputDto
                )
        );

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        idSubject
                );
    }
}
