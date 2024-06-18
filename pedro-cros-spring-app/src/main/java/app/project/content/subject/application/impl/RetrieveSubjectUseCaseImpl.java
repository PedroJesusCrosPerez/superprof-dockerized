package app.project.content.subject.application.impl;

import app.project.content.subject.application.RetrieveSubjectUsecase;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.RetrieveSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveSubjectUseCaseImpl implements RetrieveSubjectUsecase {

    private final RetrieveSubjectRepository retrieveSubjectRepository;


    @Override
    public Subject findByIdSubject(Long idSubject) {

        return retrieveSubjectRepository.findByIdSubject(idSubject);
    }

    @Override
    public List<Subject> findAllSubjects() {

        return retrieveSubjectRepository.findAllSubjects();
    }
}
