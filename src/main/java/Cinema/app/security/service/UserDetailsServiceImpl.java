package Cinema.app.security.service;

import Cinema.app.model.User;
import Cinema.app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    final
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByuserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
