package app.project.content.teacher.domain.repository;

import app.project.content.teacher.domain.entity.Teacher;

import java.util.List;

public abstract interface RetrieveTeacherRepository {

    List<Teacher> findAll();

    Teacher findByIdTeacher(Long idTeacher);
}
