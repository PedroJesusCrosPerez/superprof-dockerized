package app.project.content.agreement.infrastructure.controller.dto.output;

import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDtoFull;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDtoFull;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDtoFull;
import app.project.shared.enums.EPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgreementOutputDtoFull {

    private Long idAgreement;
    private String title;
    private String description;
    private String aboutMe;
    private Boolean isActive;

    private List<SubjectOutputDtoFull> subjects;
    private List<EPlace> places;
    private List<LanguageOutputDtoFull> languages;
    private RateOutputDtoFull rate;
}
