package br.com.fsrocha.fiisexplorer.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.input.UpdateUserInput;
import br.com.fsrocha.fiisexplorer.dto.output.UpdateUserOutput;
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
public class UpdateUserController {

    UserService userService;

    ModelMapper modelMapper;

    @PutMapping(value = FiiExplorerConstants.UPDATE_USER)
    public UpdateUserOutput updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserInput request) {
        userService.existsUsernameOrEmail(null, request.email);
        UserEntity userEntity = userService.findById(userService.uuidFromString(id));
        userEntity.setFullName(request.fullname);
        userEntity.setEmail(request.email);
        userEntity = userService.update(userEntity);

        return new UpdateUserOutput(userEntity.getUsername());
    }
}
