package diaconat_mulhouse.fr.backend.core.converters;

import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.createTask.JsonCreateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.createTask.JsonCreateTaskConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJson.TaskJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJson.TaskJsonConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.updateTask.JsonUpdateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.updateTask.JsonUpdateTaskConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.updateTask.UpdateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.updateTask.UpdateTaskConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    public TaskJPAConverter taskJPAConverter() {
        return new TaskJPAConverterImpl();
    }

    @Bean
    public TaskJsonConverter taskJsonConverter() {
        return new TaskJsonConverterImpl();
    }

    @Bean
    public JsonCreateTaskConverter jsonCreateTaskConverter() {
        return new JsonCreateTaskConverterImpl();
    }

    @Bean
    public CreateTaskConverter createTaskConverter() {
        return new CreateTaskConverterImpl();
    }

    @Bean
    public JsonUpdateTaskConverter jsonUpdateTaskConverter() {
        return new JsonUpdateTaskConverterImpl();
    }

    @Bean
    public UpdateTaskConverter updateTaskConverter() {
        return new UpdateTaskConverterImpl();
    }
}
