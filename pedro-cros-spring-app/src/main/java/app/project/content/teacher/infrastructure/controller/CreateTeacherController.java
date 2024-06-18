package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.CreateTeacherUseCase;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class CreateTeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;


    // POST |-> http://localhost:8080/teachers
    /**
     *  {
     *      "name": "Alice",
     *      "surname": "Smith",
     *  }
     */
    @PostMapping
    public ResponseEntity<Long> saveUser(@RequestBody TeacherCreateInputDto teacherCreateInputDto) {

        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(teacherCreateInputDto);

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        createTeacherUseCase.saveTeacher(teacher)
                );
    }
}
