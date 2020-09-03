package br.com.fsrocha.fiisexplorer.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.input.ChangePasswordInput;
import br.com.fsrocha.fiisexplorer.dto.output.ChangePasswordOutput;
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
public class ChangePasswordController {

    UserService userService;

    @PostMapping(value = FiiExplorerConstants.CHANGE_PASSWORD)
    public ChangePasswordOutput changePassword(@RequestBody ChangePasswordInput request) {
        userService.changePassword(request.username, request.newPassword);

        return new ChangePasswordOutput();
    }
}
