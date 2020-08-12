package br.com.fsrocha.fiisexplorer.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fsrocha.fiisexplorer.model.UserEntity;

/**
 * @author Filipe Rocha
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserEntity findByUsername(String username);

}
