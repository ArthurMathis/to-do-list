import { Component, inject, OnInit, signal } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass } from '@angular/common';
import { TaskService } from '../../../domain/services/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import Task from '../../../domain/models/task.model';

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
export class TaskInput implements OnInit {
  
  // * INJECTS * //
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
   * @var {ActivatedRoute} activatedRoute The current URL
   */
  protected activatedRoute = inject(ActivatedRoute);

  // * ATTRIBUTES * // 
  /**
   * @var {WritableSignal<Task|undefined>} task The task to update, if we don't create a new task
   */
  protected task = signal<Task|undefined>(undefined);
  /**
   * @var {FormGroup} formGroup The FormGroup
   */
  protected formGroup: FormGroup; 

  // * ONINIT * // 
  public ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    if(id) {
      const fetchTask = this.taskService.get(parseInt(id));
      this.task.set(fetchTask);

      if (fetchTask) {
        this.formGroup.patchValue({
          titled: fetchTask.getTitled()
        });
      }
    }
  }

  /**
   * @constructor
   */
  public constructor() {
    this.formGroup = this.formBuilder.group({
      titled: ["", Validators.required]
    });
  }

  // * SIGNAL MANIPULATION * //
  /**
   * @function handleSubmit 
   * @description Protected method that creates the new task
   * @param event The submit event of the html form
   */
  protected handleSubmit(event: Event): void {
    event.preventDefault();
    const response = this.formGroup.get('titled')!.value;

    if(this.task()) {
      const updatedTask = Task.fromInterface({
        id: this.task()!.getId(),
        titled: response,
        checked: this.task()!.getChecked()
      });
      this.taskService.update(updatedTask);
    } else {
      this.taskService.create(response!);
    }

    this.router.navigate([ "/home" ]);
  }
}
