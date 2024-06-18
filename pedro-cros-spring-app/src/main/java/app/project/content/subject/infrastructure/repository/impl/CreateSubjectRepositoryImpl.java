package app.project.content.subject.infrastructure.repository.impl;

import app.project.content.subject.application.mapper.SubjectEntityMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.CreateSubjectRepository;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateSubjectRepositoryImpl implements CreateSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Long saveSubject(Subject subject) {

        SubjectJpa subjectJpa = SubjectEntityMapper.INSTANCE.toEntityJpa(subject);
        return subjectRepositoryJpa.save(
//                SubjectMapper.INSTANCE.toEntityJpa(subject)
                subjectJpa
        ).getIdSubject();
    }
}
