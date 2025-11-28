package diaconat_mulhouse.fr.backend.presentation.controllers;

import diaconat_mulhouse.fr.backend.application.services.UserService;
import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.AuthToken;
import diaconat_mulhouse.fr.backend.presentation.DTOs.user.LoginUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "auth")
@AllArgsConstructor
public class AuthentificationController {

    private final UserService userService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public AuthToken authenticate(@RequestBody LoginUserDTO loginUserDTO) {
        return this.userService.authenticate(loginUserDTO);
    }

}
