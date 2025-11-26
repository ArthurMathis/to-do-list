package diaconat_mulhouse.fr.backend.application.converters.task.jpa;

import diaconat_mulhouse.fr.backend.domain.entities.task.Task;
import diaconat_mulhouse.fr.backend.domain.entities.task.TaskJPA;
import diaconat_mulhouse.fr.backend.domain.entities.user.UserJPA;
import diaconat_mulhouse.fr.backend.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskJPAConverterImpl implements TaskJPAConverter {

    private final UserRepository userRepository;

    public TaskJPAConverterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public TaskJPA fromDto(Task task) {
        return TaskJPA.builder()
                .id(task.getId())
                .titled(task.getTitled())
                .description(task.getDescription())
                .checked(task.isChecked())
                .users(this.userRepository.findAllById(task.getUsersId()))
                .createdAt(task.getCreatedAt())
                .build();
    }

    @Override
    public Task toDto(TaskJPA taskJPA) {
        return Task.builder()
                .id(taskJPA.getId())
                .titled(taskJPA.getTitled())
                .description(taskJPA.getDescription())
                .checked(taskJPA.isChecked())
                .usersId(taskJPA.getUsers().stream().map(UserJPA::getId).toList())
                .createdAt(taskJPA.getCreatedAt())
                .build();
    }
}
