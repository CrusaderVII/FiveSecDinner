package egor.family.five_sec_dinner_service.service.impl;

import egor.family.five_sec_dinner_service.dao.model.User;
import egor.family.five_sec_dinner_service.repository.UserRepository;
import egor.family.five_sec_dinner_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //TODO: return user not optional

    private final UserRepository repository;

    @Override
    public Optional<User> findUserDyId(UUID id) {
        return repository.findById(id);
    }
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }
}
