package app.project.content.subject.infrastructure.repository.impl;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.UpdateSubjectRepository;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateSubjectRepositoryImpl implements UpdateSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Subject updateSubject(Subject subject) {

        return null;
    }
}
