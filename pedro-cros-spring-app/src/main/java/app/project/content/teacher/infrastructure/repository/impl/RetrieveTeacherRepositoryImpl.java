package app.project.content.teacher.infrastructure.repository.impl;

import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.RetrieveTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveTeacherRepositoryImpl implements RetrieveTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public List<Teacher> findAll() {

//        return UserEntityMapper.INSTANCE.toEntityList(
//                userRepositoryJpa.findAll()
//        );

        List<TeacherJpa> usersJpa = teacherRepositoryJpa.findAll();
        List<Teacher> users = TeacherEntityMapper.INSTANCE.toEntityList(usersJpa);

        return users;
    }

    @Override
    public Teacher findByIdTeacher(Long idTeacher) {

        return teacherRepositoryJpa.findById(idTeacher)
                .map(TeacherEntityMapper.INSTANCE::toEntity)
                // TODO cambiar por excepcion personalizada
                .orElseThrow( () -> new EntityNotFoundException("User not found"));
    }
}
