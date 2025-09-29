import { Component, input, output } from '@angular/core';
import { NgClass } from '@angular/common';
import Task from '../../../domain/models/task.model';

@Component({
  selector: 'app-task-card',
  imports: [
    NgClass
  ],
  templateUrl: './task-card.html',
  styleUrl: './task-card.css'
})
export class TaskCard {

  /**
   * @var {InputSignal<Task>} task The task to show in the card
   */
  public task = input.required<Task>();

  /**
   * @var {OutputEmitterRef<number>} taskCheck The output signal to check the task 
   */
  protected taskCheck  = output<number>();
  /**
   * @var {OutputEmitterRef<number>} taskUpdate The output signal to update the task 
   */
  protected taskUpdate = output<number>();
  /**
   * @var {OutputEmitterRef<number>} taskDelete The output signal to delete the task 
   */
  protected taskDelete = output<number>();

  //// SIGNAL //// 
  /**
   * @function handleCheck
   * @description Protected method that handle the check signal 
   * @returns {void}
   */
  protected handleCheck(): void {
    this.taskCheck.emit(this.task().getId());
  }

  /**
   * @function handleUpdate
   * @description Protected method that handle the update signal 
   * @returns {void}
   */
  protected handleUpdate(): void {
    this.taskUpdate.emit(this.task().getId());
  }

  /**
   * @function handleDelete
   * @description Protected method that handle the delete signal 
   * @returns {void}
   */
  protected handleDelete(): void {
    this.taskDelete.emit(this.task().getId());
  }
}