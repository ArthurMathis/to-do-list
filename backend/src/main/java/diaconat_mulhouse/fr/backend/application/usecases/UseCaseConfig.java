package diaconat_mulhouse.fr.backend.application.usecases;

import diaconat_mulhouse.fr.backend.application.usecases.task.create.CreateTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.create.CreateTaskUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.task.delete.DeleteTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.delete.DeleteTaskUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.task.get.GetTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.get.GetTaskUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.task.list.ListTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.list.ListTaskUseCaseImpl;
import diaconat_mulhouse.fr.backend.application.usecases.task.update.UpdateTaskUseCase;
import diaconat_mulhouse.fr.backend.application.usecases.task.update.UpdateTaskUseCaseImpl;
import diaconat_mulhouse.fr.backend.core.gateways.task.create.CreateTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.delete.DeleteTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.get.GetTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.index.IndexTaskGateway;
import diaconat_mulhouse.fr.backend.core.gateways.task.update.UpdateTaskGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ListTaskUseCase ListTask(IndexTaskGateway indexTaskGateway) {
        return new ListTaskUseCaseImpl(indexTaskGateway);
    }

    @Bean
    public GetTaskUseCase getTask(GetTaskGateway getTaskGateway) {
        return new GetTaskUseCaseImpl(getTaskGateway);
    }

    @Bean
    public CreateTaskUseCase createTask(CreateTaskGateway createTaskGateway) {
        return new CreateTaskUseCaseImpl(createTaskGateway);
    }

    @Bean
    public UpdateTaskUseCase updateTask(UpdateTaskGateway updateTaskGateway) {
        return new UpdateTaskUseCaseImpl(updateTaskGateway);
    }

    @Bean
    public DeleteTaskUseCase deleteTask(DeleteTaskGateway deleteTaskGateway) {
        return new DeleteTaskUseCaseImpl(deleteTaskGateway);
    }
}
