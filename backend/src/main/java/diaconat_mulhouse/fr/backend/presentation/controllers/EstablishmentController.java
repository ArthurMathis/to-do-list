package diaconat_mulhouse.fr.backend.presentation.controllers;

import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.CreateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.EstablishmentJsonDTO;
import diaconat_mulhouse.fr.backend.presentation.DTOs.establishment.UpdateEstablishmentDTO;
import diaconat_mulhouse.fr.backend.application.services.establishment.EstablishmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "establishments")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @GetMapping
    public List<EstablishmentJsonDTO> index() {
        return this.establishmentService.index();
    }

    @GetMapping(path = "{id}")
    public EstablishmentJsonDTO get(@PathVariable long id) {
        return this.establishmentService.get(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody CreateEstablishmentDTO createEstablishmentDTO) {
        return this.establishmentService.create(createEstablishmentDTO);
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable long id, @RequestBody UpdateEstablishmentDTO updateEstablishmentDTO) {
        if(id != updateEstablishmentDTO.id()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        this.establishmentService.update(updateEstablishmentDTO);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        this.establishmentService.delete(id);
    }
}
