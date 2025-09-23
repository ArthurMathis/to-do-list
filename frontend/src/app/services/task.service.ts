import { effect, Injectable } from '@angular/core';
import Task from '../models/task.model';

/**
 * @class TaskService
 * @classdesc The Service Task
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
@Injectable({
  providedIn: 'root'
})
export class TaskService {
  
  /**
   * @var {number} currentKey The current key for task creation
   */
  protected currentKey: number;
  /**
   * @var {Array<Task>} data The array that contains the list of tasks
   */
  protected data: Array<Task>;

  /**
   * @constructor
   */
  public constructor() {
    this.data = [
      Task.fromInterface({
        id     : 1,
        titled : "Faire la lessive",
        checked: false
      }),
      Task.fromInterface({
        id     : 2,
        titled : "Réviser l'économie",
        checked: false
      }),
      Task.fromInterface({
        id     : 3,
        titled : "Ranger la vaisselle",
        checked: false
      }),
      Task.fromInterface({
        id     : 4,
        titled : "Coder",
        checked: true
      }),
    ];

    this.currentKey = 5;

    effect(() => {
      console.table(this.data);
    });
  }

  /**
   * @function index
   * @returns The list of tasks
   */
  public index(): Array<Task> {
    return Array.from(this.data);
  }

  /**
   * @function get
   * @param {number} index The index of the task to return 
   * @returns {Task|undefined} The task 
   */
  public get(index: number): Task|undefined {
    return this.data.find(el => el.getId() === index);
  }

  /**
   * @function create
   * @param titled The titled of the new task
   * @returns {number} The primay of the task
   */
  public create(titled: string): number {
    const task = Task.fromInterface({
      id: this.currentKey,
      titled: titled,
      checked: false
    });
    this.currentKey++;

    this.data.push(task);
    return this.data.indexOf(task);
  }

  /**
   * @function update
   * @param {Task} updatedTask The Task that contains the new peices of data
   * @returns {void}
   */
  public update(updatedTask: Task): void {
    const task = this.data.find(el => el.getId() === updatedTask.getId());
    if(!task) {
      throw new Error("Impossible de mettre à jour une tâche qui n'existe pas.");
    }

    const index = this.data.indexOf(task);
    this.data[index] = updatedTask.copy();
  }

  /**
   * @function delete
   * @param {number} deletedTask The primary key of the task to delete
   * @return {void}
   */
  public delete(deletedTask: number): void {
    const task = this.data.find(el => el.getId() === deletedTask);
    if(!task) {
      throw new Error("Impossible de suuprimer une tâche qui n'existe pas.");
    }

    const index = this.data.indexOf(task);
    this.data.splice(index, 1);
  }
}
