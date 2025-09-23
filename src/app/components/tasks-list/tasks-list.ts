import { Component, input, OutputEmitterRef, output } from '@angular/core';
import Task from '../../models/task.model';
import { TaskCard } from '../task-card/task-card';

@Component({
  selector: 'app-tasks-list',
  imports: [
    TaskCard
  ],
  templateUrl: './tasks-list.html',
  styleUrl: './tasks-list.css'
})
export class TasksList {

  /**
   * @var {InputSignal<Array<Task>>} taskList The list of tasks
   */
  public taskList = input.required<Array<Task>>();

  /**
   * @var {OutputEmitterRef<number>} taskCheck The output signal to check the task 
   */
  protected taskCheck: OutputEmitterRef<number>  = output<number>();
  /**
   * @var {OutputEmitterRef<number>} taskUpdate The output signal to update the task 
   */
  protected taskUpdate: OutputEmitterRef<number> = output<number>();
  /**
   * @var {OutputEmitterRef<number>} taskDelete The output signal to delete the task 
   */
  protected taskDelete: OutputEmitterRef<number> = output<number>();

  /**
   * @function handleCheck
   * @description Protected method that handle the check signal 
   * @param {number} taskId The primary key of the task
   * @returns {void}
   */
  protected handleCheck(taskId: number): void {
    this.taskCheck.emit(taskId);
  }

  /**
   * @function handleUpdate
   * @description Protected method that handle the update signal 
   * @param {number} taskId The primary key of the task
   * @returns {void}
   */
  protected handleUpdate(taskId: number): void {
    this.taskUpdate.emit(taskId);
  }

  /**
   * @function handleDelete
   * @description Protected method that handle the delete signal 
   * @param {number} taskId The primary key of the task
   * @returns {void}
   */
  protected handleDelete(taskId: number): void {
    this.taskDelete.emit(taskId);
  }

}
