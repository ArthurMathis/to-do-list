import { Component, DestroyRef, effect, inject } from '@angular/core';
import { TaskService } from '../../../domain/services/task.service';
import { TaskCard } from '../../components/task-card/task-card';
import { Router } from '@angular/router';
import { takeUntilDestroyed, toSignal } from '@angular/core/rxjs-interop';
import { BehaviorSubject, catchError, of, switchMap } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-home',
  imports: [
    TaskCard
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

  protected taskService = inject(TaskService);
  protected router = inject(Router);

  protected refreshTaskList = new BehaviorSubject<void>(undefined);
  protected taskList = toSignal(
    this.refreshTaskList.pipe(
      switchMap(() => this.taskService.index())
    ), {
      initialValue: undefined
    }
  )

  constructor(private destroyRef: DestroyRef) {}

  protected handleCheck(taskId: number): void {
    this.taskService.get(taskId).pipe(
      catchError((err: HttpErrorResponse) => {
        if(err.status === 404) {
          console.warn(`Erreur 404 : La tâche ${taskId} est introuvable.`);
        }
        return of(undefined)
      }),

      switchMap(fetchedTask => {
        return this.taskService.update({
          id     : fetchedTask!.Id,
          titled : fetchedTask!.Titled,
          checked: !fetchedTask!.Checked
        });
      }),

      takeUntilDestroyed(this.destroyRef) 

    ).subscribe({
      next : () => {
        this.refreshTaskList.next();
        console.log(`Mise à jour de la tâche ${taskId} réussie.`);
      },
      error: (err) => console.error(err)
    });
  }

  protected handleUpdate(taskId: number): void {
    this.router.navigate([ `/task/${taskId}` ]);
  }

  protected handleDelete(taskId: number): void {
    this.taskService.delete(taskId).pipe(
      takeUntilDestroyed(this.destroyRef)
    ).subscribe({
      next: () => {
        this.refreshTaskList.next();
        console.log(`La tâche ${taskId} a bien été supprimée`);
      },
      error: (err) => console.error(err)
    });
  }
}
