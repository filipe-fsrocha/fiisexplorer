package br.com.fsrocha.fiisexplorer.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.RegisterDto;
import br.com.fsrocha.fiisexplorer.dto.output.RegisterOutput;
import br.com.fsrocha.fiisexplorer.model.UserEntity;
import br.com.fsrocha.fiisexplorer.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterUserController {

    UserService userService;

    ModelMapper modelMapper;

    @PostMapping(value = FiiExplorerConstants.REGISTER)
    public RegisterOutput registerUser(@Valid @RequestBody RegisterDto request) {
        userService.validPassword(request.getPassword());
        userService.existsUsernameOrEmail(request.getUsername(), request.getEmail());

        UserEntity userEntity = modelMapper.map(request, UserEntity.class);
        userEntity = userService.create(userEntity);

        return new RegisterOutput(userEntity.getEmail());
    }
}
