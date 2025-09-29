import { Component, inject } from '@angular/core';
import { TaskService } from '../../../domain/services/task.service';
import Task from '../../../domain/models/task.model';
import { TaskCard } from '../../components/task-card/task-card';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [
    TaskCard
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  /**
   * @var {TaskService} taskService The instance of TaskService
   */
  protected taskService = inject(TaskService);
  /**
   * @var {Router} router The instance of Router
   */
  protected router = inject(Router);

  /**
   * @var {Array<Task>} taskList The list of task
   */
  protected taskList: Task[];

  /**
   * @constructor
   */
  public constructor() {
    this.taskList = this.taskService.index();
  }

  //// SIGNAL MANIPULATION ////
  /**
   * @function handleCheck
   * @description Protected method that checks or unchecks a Task
   * @param taskId The primary key of the task
   * @returns {void}
   */
  protected handleCheck(taskId: number): void {
    const task = this.taskService.get(taskId);
    if(!task) {
      throw new Error(`Impossible de cocher la tâche numéro : ${taskId}. Elle n'existe pas.`);
    }
    const taskUpdate = Task.fromInterface({
      id     : task.getId(),
      titled : task.getTitled(),
      checked: !task.getChecked()
    });
    this.taskService.update(taskUpdate);
    this.taskList = this.taskService.index();
  }

  /**
   * @function handkeUpdate
   * @description Protected method that shows/hides the TaskForm
   * @param taskId The primary key of the task
   */
  protected handleUpdate(taskId: number): void {
    this.router.navigate([ `/task/${taskId}` ]);
  }

  /**
   * @function handleDelete
   * @description Protected method that deletes a task from its primary key
   * @param taskId The primary key of the task
   * @returns {void}
   */
  protected handleDelete(taskId: number): void {
    this.taskService.delete(taskId);
    this.taskList = this.taskService.index();
  }
}
