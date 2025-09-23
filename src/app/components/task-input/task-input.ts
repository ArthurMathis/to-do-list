import { Component, input, output, signal } from '@angular/core';

@Component({
  selector: 'app-task-input',
  imports: [],
  templateUrl: './task-input.html',
  styleUrl: './task-input.css'
})
export class TaskInput {

  // * ATTRIBUTES * //
  /**
   * @var {WritableSignal<string>} taskTitled The input content
   */
  protected taskTitled = signal<string>("");

  /**
   * @var {OutputEmitterRef<string>} submit The ouput that submits the input
   */
  protected submit = output<string>();
  /**
   * @var {OutputEmitterRef<void>} cancel The ouput that cancels the input
   */
  protected cancel = output<void>();

  // * HANDLE * //
  /**
   * @function handleInput
   * @description Protected method that handles input events
   * @param value The input content 
   * @returns {void}
   */
  protected handleInput(value: string): void {
    this.taskTitled.set(value);
  }

  /**
   * @function handleSubmit
   * @description Protected method that handles submit events
   * @returns {void}
   */
  protected handleSubmit(): void {
    this.submit.emit(this.taskTitled());
  }

  /**
   * @function handleCancel
   * @description Protected method that handles cancel events
   * @returns {void}
   */
  protected handleCancel(): void {
    this.cancel.emit();
  }
}
