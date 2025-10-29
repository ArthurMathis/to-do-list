package diaconat_mulhouse.fr.backend.presentation.controllers;

import diaconat_mulhouse.fr.backend.application.DTOs.user.CreateUserDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.user.UpdateUserDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.user.UserJsonDTO;
import diaconat_mulhouse.fr.backend.application.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserJsonDTO> index() {
        return this.userService.index();
    }

    @GetMapping(path = "{id}")
    public UserJsonDTO get(@PathVariable long id) {
        return this.userService.get(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody CreateUserDTO createUserDTO) {
        return this.userService.create(createUserDTO);
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable long id, @RequestBody UpdateUserDTO updateUserDTO) {
        if(id != updateUserDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.userService.update(updateUserDTO);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        this.userService.delete(id);
    }
}
