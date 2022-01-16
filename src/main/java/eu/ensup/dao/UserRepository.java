package eu.ensup.dao;

import eu.ensup.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMailAndPassword(String mail, String password);

}
