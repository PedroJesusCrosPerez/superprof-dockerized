package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {TeacherEntityMapper.class})
public interface SubjectEntityMapper {

    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);


    // Entity
    @Mapping(target = "idSubject", ignore = true)
    Subject toEntity(SubjectInputDto subjectInputDto);

    Subject toEntity(SubjectJpa subjectJpa);

    @Mapping(source = "idSubject", target = "idSubject", ignore = true)
    SubjectJpa toEntityJpa(Subject subject);

    List<Subject> toEntityList(List<SubjectJpa> subjectJpaList);
}
