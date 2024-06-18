package app.project.content.teacher.domain.repository;

import app.project.content.teacher.domain.entity.Teacher;

public abstract interface UpdateTeacherRepository {

    Teacher updateTeacher(Teacher teacher);
}
