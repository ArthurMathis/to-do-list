import { Component, inject, OnInit, Signal, signal } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass } from '@angular/common';
import { TaskService } from '../../../domain/services/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Task } from '../../../domain/models/task.model';
import { toSignal } from '@angular/core/rxjs-interop';
import { TaskInterface } from '../../../domain/interfaces/task.interface';

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
  
  protected formBuilder = inject(FormBuilder);
  protected taskService = inject(TaskService);
  protected router = inject(Router);
  protected activatedRoute = inject(ActivatedRoute);

  protected task: Signal<Task|undefined>|undefined = undefined;
  protected formGroup: FormGroup; 

  constructor() {
    this.formGroup = this.formBuilder.group({
      titled: [ "", Validators.required ]
    });
  }

  ngOnInit(): void {
    const taskId = this.activatedRoute.snapshot.params['id'];
    if(taskId) {
      this.task = toSignal(this.taskService.get(taskId));
    }
  }

  protected handleSubmit(event: Event): void {
    event.preventDefault();
    const response: string = this.formGroup.get('titled')!.value;

    if(this.task) {
      const taskUpdate: TaskInterface = {
        id: this.task()!.Id,
        titled: this.task()!.Titled,
        checked: this.task()!.Checked
      };
      this.taskService.update(taskUpdate);
    } else {
      this.taskService.create({
        titled: response
      });
    }

    this.router.navigate([ "/home" ]);
  }
}
