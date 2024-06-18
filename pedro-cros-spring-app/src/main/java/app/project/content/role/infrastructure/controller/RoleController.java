package app.project.content.role.infrastructure.controller;

import org.springframework.stereotype.Controller;

@Controller
public class RoleController {

//    @GetMapping("/{role}/roles")
//    public String byRole(@PathVariable String role) {
//
//        return switch (role) {
//            case "admin" -> "roles/admin/dashboard.html";
//            case "teacher" -> "templates/roles/teacher/dashboard.html";
//            case "student" -> "templates/roles/student/dashboard.html";
//            default -> "templates/roles/unassigned/dashboard.html";
//        };
//    }

//    @GetMapping("/{role}/dashboard")
//    public String byRole(@PathVariable String role) {
//
//        return switch (role) {
//            case "admin" -> "roles/admin/dashboard.html";
//            case "teacher" -> "templates/roles/teacher/dashboard.html";
//            case "student" -> "templates/roles/student/dashboard.html";
//            default -> "templates/roles/unassigned/dashboard.html";
//        };
//    }


//    @GetMapping("/admin/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminDashboard() {
//        return "roles/admin/dashboard";
//    }
//
//    @GetMapping("/teacher/dashboard")
//    @PreAuthorize("hasRole('TEACHER')")
//    public String teacherDashboard() {
//        return "roles/teacher/dashboard";
//    }


//    @GetMapping("/admin/dashboard")
//    public String adminDashboard() {
//        return "roles/admin/dashboard";
//    }
//
//    @GetMapping("/teacher/dashboard")
//    public String teacherDashboard() {
//        return "roles/teacher/dashboard";
//    }
}
