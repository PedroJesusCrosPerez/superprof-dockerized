package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.CreateTeacherUseCase;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.CreateTeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTeacherUseCaseImpl implements CreateTeacherUseCase {

    private final CreateTeacherRepository createTeacherRepository;


    @Override
    public Long saveTeacher(Teacher teacher) {

        return createTeacherRepository.createTeacher(teacher);
    }
}
