package app.project.controller;

import app.project.content.agreement.infrastructure.repository.jpa.AgreementRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PageController {


    @GetMapping("/")
    public String start() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }




    @GetMapping("/findByIdTeacher")
    public String teacherById(@RequestParam(defaultValue = "1") Long idTeacher) {
        return "findByIdTeacher";
    }


    private final AgreementRepositoryJpa agreementRepositoryJpa;

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("agreements", agreementRepositoryJpa.findAll());
        return "test";
    }


    @GetMapping("/dashboard")
    public String dashboard() {
        return "roles/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard_admin() {
        return "roles/admin/dashboard";
    }


    @GetMapping("/teacher/dashboard")
    public String dashboard_teacher() {
        return "roles/teacher/dashboard";
    }



    @GetMapping("/subject/search")
    public String subject_search(

    ) {
        return "roles/unassigned/findBySubjectName";
    }
//    @GetMapping("/user/dashboard")
//    public String dashboard_user() {
//        return "roles/user/dashboard";
//    }
}