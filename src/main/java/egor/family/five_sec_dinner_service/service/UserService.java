package egor.family.five_sec_dinner_service.service;

import egor.family.five_sec_dinner_service.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {

    User findUserDyId(UUID id);
    User saveUser(User user);
    void deleteUserById(UUID id);
    User updateUser(User user);

}
