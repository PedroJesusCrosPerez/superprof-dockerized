package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {TeacherEntityMapper.class})
public interface SubjectDtoMapper {

    SubjectDtoMapper INSTANCE = Mappers.getMapper(SubjectDtoMapper.class);


    // DTO
    List<SubjectOutputDto> toOutputDtoList(List<Subject> subjectList);

    List<SubjectOutputDtoFull> toOutputDtoFullList(List<Subject> subjectList);

    SubjectOutputDtoFull toOutputDtoFull(Subject subject);

    SubjectOutputDto toOutputDto(Subject subject);
}
