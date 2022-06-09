package eu.ensup.service;

import eu.ensup.dao.UserRepository;
import eu.ensup.domaine.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Inscription
    public void create(User user){
        this.userRepository.save(user); // Methode proposé par CrudRepository pour enregistrer une entité dans la base de données
    }

    // Connexion
    public User findUser( User user){
        return this.userRepository.findByMailAndPassword(user.getMail(), user.getPassword());
    }

    // Connexion
    public User Update( User user, User newUser){
       user = this.userRepository.findByMailAndPassword(user.getMail(), user.getPassword());

        user.setMail(newUser.getMail());
        user.setPassword(newUser.getPassword());
       return user;
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }

    public void update(User user, User newUser) {
      user=  this.userRepository.findByMailAndPassword(user.getMail(),user.getPassword());
      user.setPassword(newUser.getPassword());
      user.setMail(newUser.getMail());

     ///   this.userRepository.save(user);

    }
}
