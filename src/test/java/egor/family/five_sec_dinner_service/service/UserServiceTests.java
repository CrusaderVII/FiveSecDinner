package egor.family.five_sec_dinner_service.service;

import egor.family.five_sec_dinner_service.dao.model.Role;
import egor.family.five_sec_dinner_service.dao.model.User;
import egor.family.five_sec_dinner_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService service;

    @Mock
    UserRepository repository;

    //Execute this method in beginning before all tests and only once
    @BeforeAll
    public static void init() {

    }

    @Test
    void givenUserId_validData_shouldReturnUserById() {
        //Given
        UUID id = UUID.fromString("9979cf26-e4bd-496e-a76e-24d18a815766");
        User expectedUser = new User(id, "Egor", Role.EATER);

        //When
        when(repository.findById(id)).thenReturn(Optional.of(expectedUser));

        //Then
        User testedUser = service.findUserDyId(id).orElse(new User());
        assertEquals(expectedUser, testedUser);
    }

    @Test
    void givenUserForSave_validData_shouldSaveAndReturnSavedUser() {
        //Given
        UUID id = UUID.fromString("9979cf26-e4bd-496e-a76e-24d18a815766");
        User userForSave = new User("Egor", Role.EATER);
        User expectedUser = new User(id, "Egor", Role.EATER);

        //When
        when(repository.save(userForSave)).thenReturn(expectedUser);

        //Then
        User testedUser = service.saveUser(userForSave);
        assertEquals(expectedUser, testedUser);
    }

    @Test
    void givenUserWithNewData_validData_shouldSaveAndReturnUpdatedUser() {
        //Given
        UUID id = UUID.fromString("9979cf26-e4bd-496e-a76e-24d18a815766");
        User userForSave = new User("Egor", Role.EATER);
        User expectedUserAfterSave   = new User(id, "Egor", Role.EATER);
        User expectedUserAfterUpdate = new User(id, "Egor", Role.CHIEF);

        //When
        when(repository.save(userForSave)).thenReturn(expectedUserAfterSave);
        when(repository.save(expectedUserAfterUpdate)).thenReturn(expectedUserAfterUpdate);

        //Then
        User testedUserAfterSave = service.saveUser(userForSave);
        User testedUserAfterUpdate = service.updateUser(testedUserAfterSave);
        assertEquals(expectedUserAfterUpdate, testedUserAfterUpdate);
    }


}
