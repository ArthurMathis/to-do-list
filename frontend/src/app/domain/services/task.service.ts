import { inject, Injectable } from '@angular/core';
import { Task } from '../models/task.model';
import { CreateTaskInterface, TaskInterface } from '../interfaces/task.interface';
import { Service } from './interface.service';
import { map, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TaskConverter } from '../converters/task.converter';

/**
 * @class TaskService
 * @classdesc The Service Task
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
@Injectable({
  providedIn: 'root'
})
export class TaskService implements Service<Task, TaskInterface, CreateTaskInterface> {

  private BASE_URL: string = "http://localhost:8080/task";

  private http = inject(HttpClient);
  private taskConverter = inject(TaskConverter);

  index(): Observable<Task[]> {
    return this.http.get<TaskInterface[]>(this.BASE_URL).pipe(
      map(taskDictArray => {
        return taskDictArray.map<Task>(
          taskInterface => this.taskConverter.fromInterface(taskInterface)
        )
      }),
      map(taskArray =>
        taskArray.sort((a, b) => a.Id - b.Id) 
      )
    )
  }

  get(id: number): Observable<Task> {
    return this.http.get<TaskInterface>(this.BASE_URL + `/${id}`).pipe(
      map(taskInterface => {
        return this.taskConverter.fromInterface(taskInterface)
      })
    )
  }

  create(createModelInterface: CreateTaskInterface): Observable<void> {
    return this.http.post<void>(this.BASE_URL, createModelInterface);
  }

  update(modelInterface: TaskInterface): Observable<void> {
    console.log("Request path : " + this.BASE_URL + `/${modelInterface.id}`);
    return this.http.put<void>(this.BASE_URL + `/${modelInterface.id}`, modelInterface);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(this.BASE_URL + `/${id}`);
  }
}
