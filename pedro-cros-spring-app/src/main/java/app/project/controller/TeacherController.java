package app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

    @GetMapping("/teacher/my_agreements")
    public String my_agreements() {
        return "roles/teacher/my_agreements";
    }

    @GetMapping("/teacher/findBySubjects")
    public String subjectsName(
            @RequestParam(value = "name", defaultValue = "programacion") String subjectName
    ) {
        return "roles/teacher/findBySubjectName";
    }
}
