import { Injectable } from "@angular/core";
import { ProjectModel } from "../../entities/project.model";
import { ProjectInterface } from "../../interfaces/project.interface";
import { Converter } from "../converter";
import { Builder } from "../../../core/builder";

@Injectable({
    providedIn: "root"
})
class ProjectConverter implements Converter<ProjectInterface, ProjectModel> {

    fromDto(dto: ProjectInterface): ProjectModel {
        return new Builder<ProjectModel>()
            .set("id", dto.id)
            .set("title", dto.title)
            .set("description", dto.description)
            .set("establihsmentId", dto.establihsmentId)
            .set("tasksId", dto.tasksId)
            .set("createdAt", dto.createdAt)
            .build();
    }

    toDto(model: ProjectModel): ProjectInterface {
        return {
            id: model.id,
            title: model.title,
            description: model.description,
            establihsmentId: model.establihsmentId,
            tasksId: model.tasksId,
            createdAt: model.createdAt
        };
    }
    
}

export { ProjectConverter };
