package eu.ensup.login;

import eu.ensup.dao.UserRepository;
import eu.ensup.domaine.Product;
import eu.ensup.domaine.User;
import eu.ensup.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest
class UserServiceTests {


    @InjectMocks
    private UserService userService;

    private User user;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Get an user")
    void testGetProduct() {
        user = new User("yamine@gmail.com", "564564654");

        when(userRepository.findByMailAndPassword(user.getMail(), user.getPassword())).thenReturn(user);

        userService.findUser(user);

        verify(userRepository, times(1)).findByMailAndPassword(user.getMail(), user.getPassword());
    }

    @Test
    @DisplayName("Creation of a user")
    void testCreateUser() {
        user = new User("yamine@gmail.com", "564564654");
        when(userRepository.save(user)).thenReturn(user);
        userService.create(user);
        verify(userRepository, times(1)).save(user);
    }


    @Test
    @DisplayName("Delete a user")
    void testDeleteUser() {
        user = new User("yamine@gmail.com", "564564654");

        doNothing().when(userRepository).delete(user);

        userService.delete(user);

        verify(userRepository, times(1)).delete(user);
    }

    @Test
    @DisplayName("Update a User email")
    void testUpdateUser() {
        user = new User("yamine@gmail.com", "564564654");
        User newUser = new User("yamine@gmail.com", "564564654");

         when(userRepository.save(user)).thenReturn(user);
         when(userRepository.findByMailAndPassword(user.getMail(), user.getPassword())).thenReturn(user);

       userService.update(user, newUser); // Update user


       verify(userRepository, times(1)).findByMailAndPassword(user.getMail(), user.getPassword());
       verify(userRepository, times(1)).save(user);

    }
}