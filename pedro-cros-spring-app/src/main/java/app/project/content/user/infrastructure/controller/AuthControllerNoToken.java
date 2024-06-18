package app.project.content.user.infrastructure.controller;

import app.project.content.user.application.impl.UserDetailsServiceImpl;
import app.project.content.user.domain.repository.UserRepository;
import app.project.content.user.infrastructure.dto.input.SignupRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthControllerNoToken {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        SignupRequest signupRequest = new SignupRequest();
        model.addAttribute("user", signupRequest); //model object is used to store data that is entered from form.
        return "register";

    }
    //handler method to handle user registration form submit request.

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") SignupRequest signupRequest, BindingResult result, Model model) { //Model attribute is used to extract model object which is a form data.


////        User existingUser = userDetailsService.findByEmail(signupRequest.getEmail()); //checking if entered email already exists or not.
//        User existingUser = userRepository.findByEmail(signupRequest.getEmail()).orElseThrow(
//                () -> new RuntimeException("User Not Found with email: " + signupRequest.getEmail())
//        ); //checking if entered email already exists or not.
//
//        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
//            result.rejectValue("email", null, "there is already an account existed with this email");
//        }

        if (result.hasErrors()) {
            model.addAttribute("user", signupRequest);
            return "/register"; // if any form has errors it will be redirected to register page only.
        }

        userDetailsService.saveUser(signupRequest);
        return "redirect:/register?success"; // @Valid from jakarta.validation will enable the validation fields of dto objectsto be enabled.

    }
}