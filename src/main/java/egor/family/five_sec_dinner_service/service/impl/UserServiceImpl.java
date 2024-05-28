package egor.family.five_sec_dinner_service.service.impl;

import egor.family.five_sec_dinner_service.dao.model.User;
import egor.family.five_sec_dinner_service.repository.UserRepository;
import egor.family.five_sec_dinner_service.service.UserService;
import egor.family.five_sec_dinner_service.util.exception.NoSuchUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findUserDyId(UUID id) throws NoSuchUserException{
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchUserException("with id:"+id));
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
