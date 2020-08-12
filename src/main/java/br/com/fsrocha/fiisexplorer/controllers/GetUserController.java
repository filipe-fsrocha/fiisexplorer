package br.com.fsrocha.fiisexplorer.controllers;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.UserDto;
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
public class GetUserController {

    UserService userService;

    ModelMapper modelMapper;

    @GetMapping(value = FiiExplorerConstants.GET_USER)
    public UserDto getUser(@PathVariable String id) {
        UserEntity userEntity = userService.findById(userService.uuidFromString(id));

        return modelMapper.map(userEntity, UserDto.class);
    }
}
