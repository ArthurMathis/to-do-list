package diaconat_mulhouse.fr.backend.core.converters;

import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.createTask.CreateTaskConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJPA.TaskJPAConverterImpl;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJson.TaskJsonConverter;
import diaconat_mulhouse.fr.backend.core.converters.task.taskJson.TaskJsonConverterImpl;
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
    public CreateTaskConverter createTaskConverter() {
        return new CreateTaskConverterImpl();
    }
}
