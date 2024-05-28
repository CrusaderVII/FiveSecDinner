package egor.family.five_sec_dinner_service.dao;

import egor.family.five_sec_dinner_service.dao.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO {
    Optional<User> findUserDyId(UUID id);
    User saveUser(User user);
}
