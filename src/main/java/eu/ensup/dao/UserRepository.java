package eu.ensup.dao;

import eu.ensup.domaine.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Formation, Integer> {
    @Override
    List<Formation> findAll();
}
