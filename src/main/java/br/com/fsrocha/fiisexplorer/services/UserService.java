package br.com.fsrocha.fiisexplorer.services;

import java.util.UUID;

import br.com.fsrocha.fiisexplorer.model.UserEntity;

/**
 * @author Filipe Rocha
 */
public interface UserService {

    UserEntity create(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    UserEntity findById(UUID id);

    void existsUsernameOrEmail(String username, String email);

    void validPassword(String password);

    UUID uuidFromString(String uuid);

}