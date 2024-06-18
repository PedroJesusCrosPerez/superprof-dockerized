package app.project.content.subject.application;

import app.project.content.subject.domain.entity.Subject;

public interface CreateSubjectUseCase {

    Long saveSubject(Subject subject);
}
