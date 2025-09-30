package diaconat_mulhouse.fr.backend.presentation.controllers;

import diaconat_mulhouse.fr.backend.application.DTOs.*;
import diaconat_mulhouse.fr.backend.application.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "task")
public class TaskController {

    protected TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskJsonDTO> index() {
        return this.taskService.getAll();
    }

    @GetMapping(path = "{id}")
    public TaskJsonDTO get(@PathVariable long id) {
        return this.taskService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody JsonCreateTaskDTO task) {
        this.taskService.create(task);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}")
    public void update(@PathVariable long id, @RequestBody JsonUpdateTaskDTO jsonUpdateTaskDTO) {
        if(id != jsonUpdateTaskDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.taskService.update(jsonUpdateTaskDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        this.taskService.delete(id);
    }
}