package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.RetrieveTeacherUseCase;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.RetrieveTeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveTeacherUseCaseImpl implements RetrieveTeacherUseCase {

    private final RetrieveTeacherRepository retrieveTeacherRepository;


    @Override
    public Teacher findByIdTeacher(Long idTeacher) {
        return retrieveTeacherRepository.findByIdTeacher(idTeacher);
    }

    @Override
    public List<Teacher> findAll() {
        return retrieveTeacherRepository.findAll();
    }
}
