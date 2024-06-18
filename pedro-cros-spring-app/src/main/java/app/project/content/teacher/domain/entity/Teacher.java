package app.project.content.teacher.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {

    private Long idTeacher;
    private String name;
    private String city;
    private String surname; // TODO borrar, añadir
    private Boolean is;
}
