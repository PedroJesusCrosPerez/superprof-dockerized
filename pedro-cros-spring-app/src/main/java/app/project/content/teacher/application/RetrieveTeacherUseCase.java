package app.project.content.teacher.application;

import app.project.content.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherUseCase {

    Teacher findByIdTeacher(Long idTeacher);

    List<Teacher> findAll();
}
