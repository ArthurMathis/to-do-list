package diaconat_mulhouse.fr.backend.core.gateways;

import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.core.gateways.task.create.CreateTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.create.CreateTaskGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.task.delete.DeleteTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.delete.DeleteTaskGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.task.get.GetTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.get.GetTaskGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.task.index.IndexTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.index.IndexTaskGatewayImpl;
import diaconat_mulhouse.fr.backend.core.gateways.task.update.UpdateTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.update.UpdateTaskGatewayImpl;
import diaconat_mulhouse.fr.backend.domain.repositories.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public IndexTaskGateway indexTaskGateway(TaskRepository taskRepository, TaskJPAConverter taskJPAConverter) {
        return new IndexTaskGatewayImpl(taskRepository, taskJPAConverter);
    }

    @Bean
    public GetTaskGateway getTaskGateway(TaskRepository taskRepository, TaskJPAConverter taskJPAConverter) {
        return new GetTaskGatewayImpl(taskRepository, taskJPAConverter);
    }

    @Bean
    public CreateTaskGateway createTaskGateway(TaskRepository taskRepository, CreateTaskConverter createTaskConverter) {
        return new CreateTaskGatewayImpl(taskRepository, createTaskConverter);
    }

    @Bean
    public UpdateTaskGateway updateTaskGateway(TaskRepository taskRepository,  TaskJPAConverter taskJPAConverter) {
        return new UpdateTaskGatewayImpl(taskRepository, taskJPAConverter);
    }

    @Bean
    public DeleteTaskGateway deleteTaskGateway(TaskRepository taskRepository) {
        return new DeleteTaskGatewayImpl(taskRepository);
    }
}
