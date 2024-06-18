package app.project.content.subject.application.impl;

import app.project.content.subject.application.UpdateSubjectUseCase;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.UpdateSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSubjectUseCaseImpl implements UpdateSubjectUseCase {

    private final UpdateSubjectRepository updateSubjectRepository;


    @Override
    public Subject updateSubject(Subject subject) {

        return null;
    }
}
