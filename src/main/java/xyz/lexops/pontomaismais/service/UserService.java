package xyz.lexops.pontomaismais.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lexops.pontomaismais.exceptions.UserNotFoundException;
import xyz.lexops.pontomaismais.model.User;
import xyz.lexops.pontomaismais.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long id){
        findById(id);
        userRepository.deleteById(id);
    }

}
