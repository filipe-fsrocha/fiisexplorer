package br.com.fsrocha.fiisexplorer.services;

import java.util.UUID;

import javax.inject.Inject;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fsrocha.fiisexplorer.model.UserEntity;
import br.com.fsrocha.fiisexplorer.repositories.UserRepository;
import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Filipe Rocha
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        log.info("Registering user with name {}", userEntity.getUsername());
        UserEntity user = userRepository.save(userEntity);
        log.info("Registered user.");
        return user;
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        UserEntity user = userRepository.findByUsername(userEntity.getUsername());
        user.setFullName(userEntity.getFullName());
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user = userRepository.save(user);

        return user;
    }

    @Override
    public UserEntity findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @Override
    public void existsUsernameOrEmail(String username, String email) {
        if (userRepository.existsByUsername(username) && Strings.isNotBlank(username)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, String.format("Já existe um usuário cadastrado com o nome %s", username));
        }
        if (userRepository.existsByEmail(email) && Strings.isNotBlank(email)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, String.format("Já existe um usuário cadastrado com o e-mail %s", email));
        }
    }

    @Override
    public void validPassword(String password) {
    }

    @Override
    public UUID uuidFromString(String uuid) {
        try {
            return UUID.fromString(uuid);
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, e);
        }
    }
}
