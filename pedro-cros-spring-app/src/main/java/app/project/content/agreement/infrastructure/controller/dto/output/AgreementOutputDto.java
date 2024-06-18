package app.project.content.agreement.infrastructure.controller.dto.output;

import app.project.content.language.infrastructure.controller.dto.output.LanguageOutputDto;
import app.project.content.rate.infrastructure.controller.dto.output.RateOutputDto;
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
public class AgreementOutputDto {

    private Long idAgreement;
    private String title;
    private List<EPlace> places;
    private List<LanguageOutputDto> languages;
    private RateOutputDto rate;
}
