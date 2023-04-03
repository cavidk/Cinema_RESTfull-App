//package Cinema.app.security.controllers;
//
//
//import Cinema.app.model.Role;
//import Cinema.app.model.User;
//import Cinema.app.model.UserRole;
//import Cinema.app.repository.Rolerepository;
//import Cinema.app.repository.UserRepository;
//import Cinema.app.security.jwt.JwtUtils;
//import Cinema.app.security.service.UserDetailsImpl;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseCookie;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    final
//    AuthenticationManager authenticationManager;
//
//    final
//    UserRepository userRepository;
//
//    final
//    Rolerepository roleRepository;
//
//    final
//    PasswordEncoder encoder;
//
//    final
//    JwtUtils jwtUtils;
//
//    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, Rolerepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.encoder = encoder;
//        this.jwtUtils = jwtUtils;
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getuserName(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        roles));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//        }
//
//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//        }
//
//        // Create new user's account
//        User user = new User(signUpRequest.getUsername(),
//                signUpRequest.getEmail(),
//                encoder.encode(signUpRequest.getPassword()));
//
//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(UserRole.USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(UserRole.ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(UserRole.USER)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//    }
//
//    @PostMapping("/signout")
//    public ResponseEntity<?> logoutUser() {
//        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//                .body(new MessageResponse("You've been signed out!"));
//    }
//
//}
