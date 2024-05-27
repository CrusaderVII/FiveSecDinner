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

    private final UserRepository repository;

    @Override
    public Optional<User> findUserDyId(UUID id) {
        return Optional.empty();
    }
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(UUID id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
