import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass } from '@angular/common';
import { TaskService } from '../../../domain/services/task.service';
import { Router } from '@angular/router';

/**
 * @class TaskInput
 * @classdesc The input that create a new task
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
@Component({
  selector: 'app-task-input',
  imports: [
    ReactiveFormsModule,
    NgClass
],
  templateUrl: './task-input.html',
  styleUrl: './task-input.css'
})
export class TaskInput {

  /**
   * @var {FormBuilder} formBuilder The FormBuilder
   */
  protected formBuilder = inject(FormBuilder);
  /**
   * @var {TaskService} taskService The TaskService
   */
  protected taskService = inject(TaskService);
  /**
   * @var {Router} router The Router
   */
  protected router = inject(Router);
  
  /**
   * @var {FormGroup} formGroup The FormGroup
   */
  protected formGroup = this.formBuilder.group({
    titled: [ "", Validators.required ]
  });

  /**
   * @function handleSubmit 
   * @description Protected method that creates the new task
   * @param event The submit event of the html form
   */
  protected handleSubmit(event: Event): void {
    event.preventDefault();
    const response = this.formGroup.get('titled')?.value;
    this.taskService.create(response!);
    this.router.navigate(["/home"]);
  }
}
