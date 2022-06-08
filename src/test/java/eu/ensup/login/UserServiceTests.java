package eu.ensup.login;

import eu.ensup.dao.UserRepository;
import eu.ensup.domaine.User;
import eu.ensup.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Creation of a user")
    void create() {
        user = new User("yamine@gmail.com", "564564654");

        Mockito.when(userRepository.save(user)).thenReturn(user);

        //Mockito.verify(userRepository).save(user);

        Assertions.assertEquals(user.getPassword(), user.getPassword());
        Assertions.assertEquals(user.getMail(), user.getMail());

    }
}