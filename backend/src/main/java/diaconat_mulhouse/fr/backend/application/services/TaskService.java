package diaconat_mulhouse.fr.backend.application.services;

import diaconat_mulhouse.fr.backend.application.DTOs.CreateTaskDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.TaskJsonDTO;
import diaconat_mulhouse.fr.backend.application.DTOs.UpdateTaskDTO;
import diaconat_mulhouse.fr.backend.application.usecases.task.create.CreateTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.delete.DeleteTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.get.GetTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.list.ListTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.update.UpdateTaskUseCase;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJson.TaskJsonConverter;
import diaconat_mulhouse.fr.backend.domain.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The task Service
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
@Service
public class TaskService {

    protected TaskJsonConverter taskJsonConverter;
    protected ListTaskUseCase listTaskUseCase;
    protected GetTaskUseCase getTaskUseCase;
    protected CreateTaskUseCase createTaskUseCase;
    protected UpdateTaskUseCase updateTaskUseCase;
    protected DeleteTaskUseCase deleteTaskUseCase;

    public TaskService(
            ListTaskUseCase listTaskUseCase,
            TaskJsonConverter taskJsonConverter,
            GetTaskUseCase getTaskUseCase,
            CreateTaskUseCase createTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase
    ) {
        this.listTaskUseCase = listTaskUseCase;
        this.taskJsonConverter = taskJsonConverter;
        this.getTaskUseCase = getTaskUseCase;
        this.createTaskUseCase = createTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    /**
     * Public method that returns the complete list of tasks.
     *
     * @return a list of TaskJsonDTO objects representing all tasks
     */
    public List<TaskJsonDTO> getAll() {
        List<Task> tasks = this.listTaskUseCase.execute();
        return tasks.stream().map(this.taskJsonConverter::toDto).toList();
    }

    /**
     * Public method that returns a task from its primary key
     *
     * @param id The primary key of the task
     * @return The task
     */
    public TaskJsonDTO get(long id) {
        Task task = this.getTaskUseCase.execute(id);
        return this.taskJsonConverter.toDto(task);
    }

    /**
     * Public method that inserts a naw task in the database
     *
     * @param createTaskDTO The task to insert
     */
    public void create(CreateTaskDTO createTaskDTO) {
        this.createTaskUseCase.execute(createTaskDTO);
    }

    /**
     * Public method that updates a Task
     *
     * @param updateTaskDTO The updated task
     */
    public void update(UpdateTaskDTO updateTaskDTO) {
        this.updateTaskUseCase.execute(updateTaskDTO);
    }

    /**
     * Public method that deletes a Task from its primary key
     *
     * @param id The primary key of the task
     */
    public void delete(long id) {
        this.deleteTaskUseCase.execute(id);
    }
}