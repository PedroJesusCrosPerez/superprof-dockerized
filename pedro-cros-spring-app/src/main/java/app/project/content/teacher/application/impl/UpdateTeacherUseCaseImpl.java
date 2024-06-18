package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.UpdateTeacherUseCase;
import app.project.content.teacher.domain.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTeacherUseCaseImpl implements UpdateTeacherUseCase {

//    private final UpdateUserRepository updateUserRepository;


    @Override
    public Teacher updateTeacher(Teacher teacher) {
//        return updateUserRepository.updateUser(user2);
        return new Teacher();
    }
}
