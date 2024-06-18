package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
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
public class TeacherEntityMapperImpl implements TeacherEntityMapper {

    @Override
    public Teacher toEntity(TeacherJpa teacherJpa) {
        if ( teacherJpa == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setIdTeacher( teacherJpa.getIdTeacher() );
        teacher.setName( teacherJpa.getName() );
        teacher.setSurname( teacherJpa.getSurname() );

        return teacher;
    }

    @Override
    public Teacher toEntity(TeacherCreateInputDto teacherCreateInputDto) {
        if ( teacherCreateInputDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setName( teacherCreateInputDto.getName() );
        teacher.setSurname( teacherCreateInputDto.getSurname() );

        return teacher;
    }

    @Override
    public List<Teacher> toEntityList(List<TeacherJpa> teacherJpaList) {
        if ( teacherJpaList == null ) {
            return null;
        }

        List<Teacher> list = new ArrayList<Teacher>( teacherJpaList.size() );
        for ( TeacherJpa teacherJpa : teacherJpaList ) {
            list.add( toEntity( teacherJpa ) );
        }

        return list;
    }

    @Override
    public TeacherJpa toEntityJpa(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherJpa teacherJpa = new TeacherJpa();

        teacherJpa.setIdTeacher( teacher.getIdTeacher() );
        teacherJpa.setName( teacher.getName() );
        teacherJpa.setSurname( teacher.getSurname() );

        return teacherJpa;
    }
}
