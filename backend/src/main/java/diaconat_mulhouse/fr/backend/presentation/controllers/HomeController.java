package diaconat_mulhouse.fr.backend.presentation.controllers;

import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import diaconat_mulhouse.fr.backend.infrastructure.security.Jwt.JwtUtils;
import diaconat_mulhouse.fr.backend.presentation.DTOs.authentification.TokenUserData;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "home")
@AllArgsConstructor
public class HomeController {

    private final EstablishmentService establishmentService;

    private final Logger logger = Logger.getLogger(HomeController.class.getName());

    @GetMapping(path = "establishments")
    public List<EstablishmentJsonDTO> indexEstablishment() {
        this.logger.log(Level.INFO, "New request received at " +  LocalDateTime.now() + "on" + "/home/establishments");
        TokenUserData userData = JwtUtils.getCurrentToken();
        return this.establishmentService.indexByUserId(userData.id());
    }

}
