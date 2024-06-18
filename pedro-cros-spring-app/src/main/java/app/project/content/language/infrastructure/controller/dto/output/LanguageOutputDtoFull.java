package app.project.content.language.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LanguageOutputDtoFull {

    private Long idLanguage;
    private String name;
    private String code;
}
