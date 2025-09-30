import { Injectable } from "@angular/core";
import { TaskInterface } from "../interfaces/task.interface";
import { Converter } from "./interface.converter";
import { Task } from "../models/task.model";

/**
 * @class TaskConverter
 * @classdesc Class that implements the converter for the model Task
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
@Injectable({
    providedIn: 'root'
})
export class TaskConverter implements Converter<Task, TaskInterface> {

    fromInterface(modelInterface: TaskInterface): Task {
        return Object.assign(new Task(), modelInterface);
    }

    fromModel(model: Task): TaskInterface {
        return {
            id     : model.Id,
            titled : model.Titled,
            checked: model.Checked
        };
    }
}