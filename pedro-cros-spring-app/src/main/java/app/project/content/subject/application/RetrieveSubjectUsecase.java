package app.project.content.subject.application;

import app.project.content.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveSubjectUsecase {

    Subject findByIdSubject(Long idSubject);
    List<Subject> findAllSubjects();
}
