import { Component, output, OutputEmitterRef } from '@angular/core';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {

  /**
   * @var {OutputEmitterRef<void>} The output that emit the signal when a new task has to be created
   */
  protected createTask: OutputEmitterRef<void> = output<void>();

  /**
   * @function handleCicle
   * @description Protected method that emit the signal 
   */
  protected handleClick(): void {
    this.createTask.emit();
  }
}
