package app.project.content.subject.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {

    private Long idSubject;
    private String name;
//    private List<Agreement> agreements;
}
