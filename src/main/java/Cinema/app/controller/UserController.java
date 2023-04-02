package Cinema.app.controller;

import Cinema.app.model.User;
import Cinema.app.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




//    @PostMapping
//    public void createUser(){
//        User user = new User();
//        user.setUserName("cavid594");
//        user.setPassword("demoPrac594");
//        user.setDigitalCurrencyLoan(1000);
//        userRepository.save(user);
//    }
}
