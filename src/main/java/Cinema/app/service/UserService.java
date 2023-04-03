package Cinema.app.service;

import Cinema.app.model.User;
import Cinema.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String addUser(User user) {

        String status = "Existing User..Please Log in";
        Optional<User> list = userRepository.findById(user.getUserName());

        if (list.isEmpty()) {
            user.setUserName("");
            user.setId("");
            user.setPassword("");
            userRepository.save(user);
            status = "Success";
        }
        else {
            System.out.println(status);
        }
            return status;
    }
}