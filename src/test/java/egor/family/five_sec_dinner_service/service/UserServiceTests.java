package egor.family.five_sec_dinner_service.service;

import egor.family.five_sec_dinner_service.dao.model.Role;
import egor.family.five_sec_dinner_service.dao.model.User;
import egor.family.five_sec_dinner_service.repository.UserRepository;
import egor.family.five_sec_dinner_service.service.impl.UserServiceImpl;
import egor.family.five_sec_dinner_service.util.exception.NoSuchDataException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {

    @Mock
    UserRepository repository;
    @InjectMocks
    UserServiceImpl service;

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
        User testedUser = service.findUserDyId(id);
        assertEquals(expectedUser, testedUser);
    }

    @Test
    void givenUserId_idNotExists_shouldThrowNoSuchUserException() {
        //Given
        UUID id = UUID.fromString("9979cf26-e4bd-496e-a76e-24d18a815766");

        //Then
        assertThrows(NoSuchDataException.class, ()->service.findUserDyId(id));
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
        User userForSave = new User(id, "Egor", Role.EATER);

        //When
        when(repository.save(userForSave)).thenReturn(userForSave);

        //Then
        User testedUserAfterSave = service.saveUser(userForSave);
        testedUserAfterSave.setRole(Role.CHIEF);
        User testedUserAfterUpdate = service.updateUser(testedUserAfterSave);
        assertEquals(testedUserAfterSave.getId(), testedUserAfterUpdate.getId());
    }


}
