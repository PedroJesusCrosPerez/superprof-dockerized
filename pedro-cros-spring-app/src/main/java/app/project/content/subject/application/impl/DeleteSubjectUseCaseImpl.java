package app.project.content.subject.application.impl;

import app.project.content.subject.application.DeleteSubjectUseCase;
import app.project.content.subject.domain.repository.DeleteSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSubjectUseCaseImpl implements DeleteSubjectUseCase {

    private final DeleteSubjectRepository deleteSubjectRepository;


    @Override
    public Boolean deleteByIdSubject(Long idSubject) {

        return null;
    }
}
