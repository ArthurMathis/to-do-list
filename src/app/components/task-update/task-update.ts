import { Component, input, signal, WritableSignal, effect, output } from '@angular/core';
import Task from '../../models/task.model';

@Component({
  selector: 'app-task-update',
  imports: [],
  templateUrl: './task-update.html',
  styleUrl: './task-update.css'
})
export class TaskUpdate {

  // * ATTRIBUTES * // 
  /**
   * @var {InputSignal<Task>} task The Task to update
   */
  public task = input.required<Task>();

  /**
   * @var {WritableSignal<string>} taskTitled The signal that contains the titled of the task
   */
  protected taskTitled !: WritableSignal<string>;

  /**
   * @var {OutputEmitterRef<Task>} updatedTask The signal that emits the task after update
   */
  protected updatedTask = output<Task>();
  /**
   * @var {OutputEmitterRef<void>} cancel The signal that cancel the update
   */
  protected cancel = output<void>();

  // * CONSTRUCTOR * // 
  /**
   * @constructor
   */
  public constructor() {
    effect(() => {
      this.taskTitled = signal<string>(this.task().getTitled());
    });
  }

  // * SIGNAL MANIPULATION * // 
  /**
   * @function handleInput
   * @description Protected method that updates the titled of the task 
   * @param {string} value The new titled
   * @returns {void}
   */
  protected handleInput(value: string): void {
    this.taskTitled.set(value);
  } 

  /**
   * @function handleSubmit
   * @description Protected method taht updates the Task and submit it
   * @returns {void}
   */
  protected handleSubmit(): void {
    const newTask = Task.fromInterface({
      id     : this.task().getId(),
      titled : this.taskTitled(),
      checked: this.task().getChecked()
    });

    this.updatedTask.emit(newTask);
  }

  /**
   * @function handleCancel
   * @description Protected method that cancels the update
   * @returns {void}
   */
  protected handleCancel(): void {
    this.cancel.emit();
  }

}