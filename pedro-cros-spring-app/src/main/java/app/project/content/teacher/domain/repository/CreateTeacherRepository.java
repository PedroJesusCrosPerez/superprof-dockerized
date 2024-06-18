package app.project.content.teacher.domain.repository;

import app.project.content.teacher.domain.entity.Teacher;

public abstract interface CreateTeacherRepository {

    Long createTeacher(Teacher teacher);
}
