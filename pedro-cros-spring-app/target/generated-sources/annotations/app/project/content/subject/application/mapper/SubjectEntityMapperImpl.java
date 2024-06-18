package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T22:45:11+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SubjectEntityMapperImpl implements SubjectEntityMapper {

    @Override
    public Subject toEntity(SubjectInputDto subjectInputDto) {
        if ( subjectInputDto == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setName( subjectInputDto.getName() );

        return subject;
    }

    @Override
    public Subject toEntity(SubjectJpa subjectJpa) {
        if ( subjectJpa == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setIdSubject( subjectJpa.getIdSubject() );
        subject.setName( subjectJpa.getName() );

        return subject;
    }

    @Override
    public SubjectJpa toEntityJpa(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectJpa subjectJpa = new SubjectJpa();

        subjectJpa.setName( subject.getName() );

        return subjectJpa;
    }

    @Override
    public List<Subject> toEntityList(List<SubjectJpa> subjectJpaList) {
        if ( subjectJpaList == null ) {
            return null;
        }

        List<Subject> list = new ArrayList<Subject>( subjectJpaList.size() );
        for ( SubjectJpa subjectJpa : subjectJpaList ) {
            list.add( toEntity( subjectJpa ) );
        }

        return list;
    }
}
