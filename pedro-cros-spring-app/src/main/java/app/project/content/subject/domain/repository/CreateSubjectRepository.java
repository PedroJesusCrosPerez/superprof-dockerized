package app.project.content.subject.domain.repository;

import app.project.content.subject.domain.entity.Subject;

public interface CreateSubjectRepository {

    Long saveSubject(Subject subject);
}
