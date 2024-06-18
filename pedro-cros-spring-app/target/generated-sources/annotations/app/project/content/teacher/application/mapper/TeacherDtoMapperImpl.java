package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDtoFull;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T22:45:12+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TeacherDtoMapperImpl implements TeacherDtoMapper {

    @Override
    public TeacherOutputDto toOutputDto(Teacher user) {
        if ( user == null ) {
            return null;
        }

        TeacherOutputDto teacherOutputDto = new TeacherOutputDto();

        teacherOutputDto.setIdTeacher( user.getIdTeacher() );

        toFullName( teacherOutputDto, user );

        return teacherOutputDto;
    }

    @Override
    public TeacherOutputDtoFull toOutputDtoFull(Teacher user) {
        if ( user == null ) {
            return null;
        }

        TeacherOutputDtoFull teacherOutputDtoFull = new TeacherOutputDtoFull();

        return teacherOutputDtoFull;
    }

    @Override
    public List<TeacherOutputDto> toOutputDtoList(List<Teacher> userList) {
        if ( userList == null ) {
            return null;
        }

        List<TeacherOutputDto> list = new ArrayList<TeacherOutputDto>( userList.size() );
        for ( Teacher teacher : userList ) {
            list.add( toOutputDto( teacher ) );
        }

        return list;
    }

    @Override
    public List<TeacherOutputDtoFull> toOutputDtoFullList(List<Teacher> userList) {
        if ( userList == null ) {
            return null;
        }

        List<TeacherOutputDtoFull> list = new ArrayList<TeacherOutputDtoFull>( userList.size() );
        for ( Teacher teacher : userList ) {
            list.add( toOutputDtoFull( teacher ) );
        }

        return list;
    }
}
