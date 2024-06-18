package app.project.content.subject.infrastructure.repository.impl;

import app.project.content.subject.application.mapper.SubjectEntityMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.RetrieveSubjectRepository;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.project.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RetrieveSubjectRepositoryImpl implements RetrieveSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Subject findByIdSubject(Long idSubject) {

        return subjectRepositoryJpa.findById(idSubject)
                .map(SubjectEntityMapper.INSTANCE::toEntity)
                .orElseThrow( () -> new NotFoundException(Subject.class, idSubject) );
    }

    @Override
    public List<Subject> findAllSubjects() {

        return subjectRepositoryJpa.findAll().stream()
                .map(SubjectEntityMapper.INSTANCE::toEntity)
                .toList();
    }
}
