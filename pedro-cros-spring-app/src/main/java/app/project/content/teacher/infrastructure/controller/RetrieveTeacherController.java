package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.RetrieveTeacherUseCase;
import app.project.content.teacher.application.mapper.TeacherDtoMapper;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDtoFull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class RetrieveTeacherController {

    private final RetrieveTeacherUseCase retrieveTeacherUseCase;


    // GET |-> http://localhost:8080/teachers?outerType=full | ?outerType=full
    @GetMapping
    public ResponseEntity<List<?>> findAllTeacher(
            @RequestParam(value = "outerType", defaultValue = "simple") String outerType
    ) {

        if ("full".equalsIgnoreCase(outerType)) {

            return  ResponseEntity
                    .status(
                            HttpStatus.ACCEPTED
                    )
                    .body(
                            TeacherDtoMapper.INSTANCE.toOutputDtoFullList(
                                    retrieveTeacherUseCase.findAll()
                            )
                    );
        }

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        TeacherDtoMapper.INSTANCE.toOutputDtoList(
                                retrieveTeacherUseCase.findAll()
                        )
                );
    }

    // GET |-> http://localhost:8080/teachers/3
    @GetMapping("/{idTeacher}")
    public ResponseEntity<TeacherOutputDtoFull> findTeacherByIdTeacher(@PathVariable Long idTeacher) {

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        TeacherDtoMapper.INSTANCE.toOutputDtoFull(
                                retrieveTeacherUseCase.findByIdTeacher(idTeacher)
                        )
                );
    }
}
