import { Component, input, output, OutputEmitterRef } from '@angular/core';
import Task from '../../models/task.model';

@Component({
  selector: 'app-task-card',
  imports: [],
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
