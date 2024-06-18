package app.project.content.teacher.infrastructure.repository.impl;

import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.CreateTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Long createTeacher(Teacher teacher) {

        return teacherRepositoryJpa.save(
                TeacherEntityMapper.INSTANCE.toEntityJpa(
                        teacher
                )
        )
                .getIdTeacher();
    }
}
