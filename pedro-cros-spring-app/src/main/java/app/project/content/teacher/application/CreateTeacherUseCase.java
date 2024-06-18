package app.project.content.teacher.application;

import app.project.content.teacher.domain.entity.Teacher;

public interface CreateTeacherUseCase {

    Long saveTeacher(Teacher teacher);
}
