package app.project.content.agreement.application.mapper;

import app.project.content.agreement.domain.entity.Agreement;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDto;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFull;
import app.project.content.agreement.infrastructure.controller.dto.output.AgreementOutputDtoFullOneSubject;
import app.project.content.subject.application.mapper.SubjectDtoMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgreementDtoMapper {

    AgreementDtoMapper INSTANCE = Mappers.getMapper(AgreementDtoMapper.class);


    // OutputDto
    AgreementOutputDto toOutputDto(Agreement agreement);

    List<AgreementOutputDto> toOutputDtoList(List<Agreement> agreementList);

    AgreementOutputDtoFull toOutputDtoFull(Agreement agreement);

    @Mapping(source = "subjects", target = "subject")//, qualifiedByName = "firstSubjectToDto")
    AgreementOutputDtoFullOneSubject toOutputDtoFullOneSubject(Agreement agreement);

//    @Named("firstSubjectToDto")
    default SubjectOutputDtoFull firstSubjectToDto(List<Subject> subjects) {
        if (subjects != null && !subjects.isEmpty()) {
            return Mappers.getMapper(SubjectDtoMapper.class).toOutputDtoFull(subjects.get(0)); // Utiliza el primer Subject de la lista
        }
        return null;
    }

    List<AgreementOutputDtoFull> toOutputDtoListFull(List<Agreement> agreement);
}
