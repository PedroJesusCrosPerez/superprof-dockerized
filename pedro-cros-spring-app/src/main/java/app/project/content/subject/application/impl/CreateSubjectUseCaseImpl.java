package app.project.content.subject.application.impl;

import app.project.content.subject.application.CreateSubjectUseCase;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.CreateSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSubjectUseCaseImpl implements CreateSubjectUseCase {

    private final CreateSubjectRepository createSubjectRepository;


    @Override
    public Long saveSubject(Subject subject) {

        return createSubjectRepository.saveSubject(subject);
    }
}
