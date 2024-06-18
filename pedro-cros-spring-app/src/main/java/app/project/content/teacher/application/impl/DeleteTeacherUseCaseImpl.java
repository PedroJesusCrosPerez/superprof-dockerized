package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.DeleteTeacherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTeacherUseCaseImpl implements DeleteTeacherUseCase {

//    private final DeleteUserRepository deleteUserRepository;


    @Override
    public Boolean deleteByIdTeacher(Long idTeacher) {
//        return deleteUserRepository.deleteByIdUser(idUser);
        return false;
    }
}
