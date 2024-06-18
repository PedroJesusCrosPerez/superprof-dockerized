package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDtoFull;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface TeacherDtoMapper {

    TeacherDtoMapper INSTANCE = Mappers.getMapper(TeacherDtoMapper.class);


    TeacherOutputDto toOutputDto(Teacher user);

    TeacherOutputDtoFull toOutputDtoFull(Teacher user);

    @AfterMapping
    default void toFullName(@MappingTarget TeacherOutputDto target, Teacher source) {
        target.setFullName(source.getName() + " " + source.getSurname());
    }
    List<TeacherOutputDto> toOutputDtoList(List<Teacher> userList);

    List<TeacherOutputDtoFull> toOutputDtoFullList(List<Teacher> userList);
}
