import { Component, inject, OnInit, Signal, signal, DestroyRef } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass } from '@angular/common';
import { TaskService } from '../../../domain/services/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Task } from '../../../domain/models/task.model';
import { takeUntilDestroyed, toSignal } from '@angular/core/rxjs-interop';
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

  constructor(private destroyRef: DestroyRef) {
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
      // Task update
      this.taskService.update({
        id: this.task()!.Id,
        titled: this.task()!.Titled,
        checked: this.task()!.Checked
      }).pipe(
        takeUntilDestroyed(this.destroyRef)
      ).subscribe({
        next : () => {
          const id = this.task!()!.Id;
          console.log(`La tâche ${id} a bien été mise à jour.`);
        },
        error: (err) => console.error(err)
      })
    } else {
      // Task build
      this.taskService.create({
        titled: response
      }).pipe(
        takeUntilDestroyed(this.destroyRef)
      ).subscribe({
        next : () => console.log(`La tâche : "${response}" a bien été créée.`),
        error: (err) => console.error(err)
      })
    }

    this.router.navigate([ "/home" ]);
  }
}
