package app.project.content.language.infrastructure.controller.dto.input;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LanguageInputDto {

    @NonNull
    private String name;
    private String code;
}
