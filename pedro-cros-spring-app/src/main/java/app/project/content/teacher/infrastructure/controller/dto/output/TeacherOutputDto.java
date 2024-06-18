package app.project.content.teacher.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherOutputDto {

    private Long idTeacher;
    private String fullName;
}
