package app.project.content.agreement.infrastructure.controller.dto.input;

import app.project.content.language.infrastructure.controller.dto.input.LanguageInputDto;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectInputDto;
import app.project.shared.enums.EPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgreementsRetrieveInputDto {

    private String title;
    private String subjectName;
    private Boolean isActive;
    private String languageCode;
    private Double pricePerHour;
    private LocalDate createdDate;

    private SubjectInputDto subject;
    private List<EPlace> places;
    private List<LanguageInputDto> languages;
}
