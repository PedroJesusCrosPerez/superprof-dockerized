package app.project.content.language.infrastructure.controller.dto.input;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LanguageUpdateInputDto {

    @NonNull
    private Long idLanguage;

    @NonNull
    private String name;
    private String code;
}
