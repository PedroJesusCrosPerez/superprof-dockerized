package app.project.content.user.infrastructure.controller;

import app.project.config.security.jwt.JwtUtils;
import app.project.content.role.domain.repository.RoleRepository;
import app.project.content.user.application.impl.UserDetailsImpl;
import app.project.content.user.application.impl.UserDetailsServiceImpl;
import app.project.content.user.domain.entity.User;
import app.project.content.user.domain.repository.UserRepository;
import app.project.content.user.infrastructure.dto.input.LoginRequest;
import app.project.content.user.infrastructure.dto.input.SignupRequest;
import app.project.content.user.infrastructure.dto.output.JwtResponse;
import app.project.content.user.infrastructure.dto.output.MessageResponse;
import app.project.shared.enums.ERole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;


    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(
            @Valid @RequestBody LoginRequest loginRequest
    ) {

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername()
                                ,loginRequest.getPassword()
                        )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        System.out.println(roles);
        System.out.println(roles);
        System.out.println(roles);
        System.out.println(roles);
        System.out.println(roles);
        System.out.println(roles);

        return  ResponseEntity
                .status(
                        HttpStatus.ACCEPTED
                )
                .body(
                        new JwtResponse(
                                jwt,
                                userDetails.getId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                roles
                        )
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(
            @Valid @RequestBody SignupRequest signUpRequest
    ) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Username is already taken!")
                    );
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MessageResponse("Error: Email is already in use!")
                    );
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
        );

        user.setId(userRepository.save(user).getId()); // Generate ID


        user.addRole(
                roleRepository.findByName(ERole.ROLE_UNASSIGNED)
                        .orElseThrow(
                                () -> new RuntimeException("Error: there aren't default roles assigned in Role table.")
                        )
        );

        User newUser = userRepository.save(user);

        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
//                        newUser
                        new MessageResponse("User registered successfully! " + newUser.getEmail())
                );
    }


//    @GetMapping("/signin/accepted")
//    public String postSignIn() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String role = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .findFirst()
//                .orElse("");
//
//        if (role.equals("ROLE_ADMIN")) {
//            return "redirect:/admin/dashboard";
//        } else if (role.equals("ROLE_TEACHER")) {
//            return "redirect:/teacher/dashboard";
//        } else if (role.equals("ROLE_USER")) {
//            return "redirect:/user/dashboard";
//        } else {
//            return "redirect:/";
//        }
//    }
//    @GetMapping("/signin/accepted")
//    public String postSignIn(@RequestParam("token") String token) {
//        // Aquí puedes verificar el token y obtener el usuario correspondiente
//        // Por ahora, solo obtenemos el usuario autenticado actualmente
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String role = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .findFirst()
//                .orElse("");
//
//        if (role.equals("ROLE_ADMIN")) {
//            return "redirect:/admin/dashboard";
//        } else if (role.equals("ROLE_USER")) {
//            return "redirect:/user/dashboard";
//        } else {
//            return "redirect:/";
//        }
//    }
    @GetMapping("/signin/accepted")
    public String postSignIn(@RequestParam("token") String token) {
        // Aquí puedes verificar el token y obtener el usuario correspondiente
        // Por ahora, solo obtenemos el usuario autenticado actualmente
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("");

        if (role.equals("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard";
        } else if (role.equals("ROLE_TEACHER")) {
            return "redirect:/teacher/dashboard";
        } else if (role.equals("ROLE_USER")) {
            return "redirect:/user/dashboard";
        } else {
            return "redirect:/";
        }
    }


    @PostMapping("/register/save")
    public String registration(
            @RequestBody SignupRequest signupRequest,
            BindingResult result,
            Model model
    ) { //Model attribute is used to extract model object which is a form data.


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

    @PostMapping("/signup/withphoto")
    public ResponseEntity<MessageResponse> registerUser(
            @Valid SignupRequest signUpRequest,
            @RequestParam("photo") MultipartFile file
    ) {
        // Validaciones de existencia de usuario y correo electrónico
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Validar tipo de archivo (opcional, si es necesario)
        String photoPath = null;
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
            }

            photoPath = "errorfoto.jpg";
            // Guardar el archivo en el servidor
            try {
                String uploadsDir = "src/main/resources/static/uploads/user/";
                Path path = Paths.get(uploadsDir + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path);
//                signUpRequest.setPhoto(path.toString()); // Guardar la ruta del archivo en el objeto SignUpRequest
                photoPath = path.toString();
                // Crear nuevo usuario
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        assert photoPath != null;
        User user = new User(
                signUpRequest.getUsername()
                , signUpRequest.getEmail()
                , encoder.encode(signUpRequest.getPassword())
                , photoPath
        );


        // Guardar usuario en la base de datos
        user.setId(userRepository.save(user).getId());
        user.addRole(roleRepository.findByName(ERole.ROLE_UNASSIGNED)
                .orElseThrow(() -> new RuntimeException("Error: there aren't default roles assigned in Role table."))
        );

        User newUser = userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new MessageResponse("User registered successfully! " + newUser.getEmail()));
    }

    @PostMapping("/uploadUserImage")
    public ResponseEntity<?> uploadUserImage(@RequestPart("file") MultipartFile file) {
        // Validar tipo de archivo
        String contentType = file.getContentType();
        if (!"image/jpeg".equals(contentType) && !"image/png".equals(contentType)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
        }

        // Guardar el archivo en la carpeta especificada
        String folderPath = "src/main/resources/static/uploads/user/";
        String fileName = file.getOriginalFilename();
        Path path = Paths.get(folderPath + fileName);
        try {
            Files.copy(file.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // Set the file path to each User entity
//        user.setFotoEscudo("/uploads/user/" + fileName);
//        createUserUseCase.saveAll(equipos);

//        JwtResponse response = user.stream()
//                .map(UserMapper.INSTANCE::toOutputDto)
//                .collect(Collectors.toList());

//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        return  ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        new MessageResponse("User image uploaded successfully!")
                );
    }
}
