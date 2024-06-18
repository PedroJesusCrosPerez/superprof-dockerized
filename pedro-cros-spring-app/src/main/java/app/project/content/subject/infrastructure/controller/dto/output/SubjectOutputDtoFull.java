package app.project.content.subject.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectOutputDtoFull {

    private Long idSubject;
    private String name;
    // TODO list teachers
}
