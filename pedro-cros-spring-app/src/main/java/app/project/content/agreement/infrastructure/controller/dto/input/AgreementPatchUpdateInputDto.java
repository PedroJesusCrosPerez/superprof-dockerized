package app.project.content.agreement.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgreementPatchUpdateInputDto {

    private String title;
    private String description;
    private String aboutMe;
    private Boolean isActive;
    private Long addIdSubject;
    private Long removeIdSubject;
    private Long addIdLanguage;
    private Long removeIdLanguage;
    private Long addIdPlace;
    private Long removeIdPlace;
    private Double pricePerHour;
}
