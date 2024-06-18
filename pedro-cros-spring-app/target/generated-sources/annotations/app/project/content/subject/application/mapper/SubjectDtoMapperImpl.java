package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-18T21:57:53+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class SubjectDtoMapperImpl implements SubjectDtoMapper {

    @Override
    public List<SubjectOutputDto> toOutputDtoList(List<Subject> subjectList) {
        if ( subjectList == null ) {
            return null;
        }

        List<SubjectOutputDto> list = new ArrayList<SubjectOutputDto>( subjectList.size() );
        for ( Subject subject : subjectList ) {
            list.add( toOutputDto( subject ) );
        }

        return list;
    }

    @Override
    public List<SubjectOutputDtoFull> toOutputDtoFullList(List<Subject> subjectList) {
        if ( subjectList == null ) {
            return null;
        }

        List<SubjectOutputDtoFull> list = new ArrayList<SubjectOutputDtoFull>( subjectList.size() );
        for ( Subject subject : subjectList ) {
            list.add( toOutputDtoFull( subject ) );
        }

        return list;
    }

    @Override
    public SubjectOutputDtoFull toOutputDtoFull(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectOutputDtoFull subjectOutputDtoFull = new SubjectOutputDtoFull();

        subjectOutputDtoFull.setIdSubject( subject.getIdSubject() );
        subjectOutputDtoFull.setName( subject.getName() );

        return subjectOutputDtoFull;
    }

    @Override
    public SubjectOutputDto toOutputDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectOutputDto subjectOutputDto = new SubjectOutputDto();

        subjectOutputDto.setIdSubject( subject.getIdSubject() );
        subjectOutputDto.setName( subject.getName() );

        return subjectOutputDto;
    }
}
