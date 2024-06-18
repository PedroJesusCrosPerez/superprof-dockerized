package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface TeacherEntityMapper {

    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);


    Teacher toEntity(TeacherJpa teacherJpa);

    Teacher toEntity(TeacherCreateInputDto teacherCreateInputDto);

    List<Teacher> toEntityList(List<TeacherJpa> teacherJpaList);

    TeacherJpa toEntityJpa(Teacher teacher);
}
