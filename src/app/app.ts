import { Component, inject, signal } from '@angular/core';
import { Navbar } from './components/navbar/navbar';
import { TasksList } from "./components/tasks-list/tasks-list";
import { TaskInput } from "./components/task-input/task-input";
import { TaskService } from './services/task.service';
import Task from './models/task.model';
import { TaskUpdate } from './components/task-update/task-update';


@Component({
  selector: 'app-root',
  imports: [
    Navbar,
    TasksList,
    TaskInput,
    TaskUpdate
],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  // * ATTRIBUTES * //
  /**
   * @var {TaskService} taskService The TaskService
   */
  protected taskService: TaskService = inject(TaskService);

  /**
   * @var {Array<Task>} taskList The array that contains the list of tasks
   */
  protected taskList: Array<Task>;
  /**
   * @var {Task|undefined} currenTaskUpdate The task that is being updated
   */
  protected currenTaskUpdate: Task|undefined;

  /**
   * @var {WritableSignal<boolean>} showTaskInput The signal that shows/hides the TaskInput component for create task
   */
  protected showTaskInput = signal<boolean>(false);
  /**
   * @var {WritableSignal<boolean>} showTaskUpdate The signal that shows/hides the TaskInput component for update task
   */
  protected showTaskUpdate = signal<boolean>(false);

  // * CONSTRUCTOR * // 
  /**
   * @constructor
   */
  public constructor() {
    this.taskList = this.taskService.index();
  }

  // * INTERFACE MANIPULATION * //
  /**
   * @function updateShowTaskInput
   * @description Protected method that update the TaskInput component for create task
   * @param {boolean} value The new state of the TaskInput
   * @returns {void}
   */
  protected updateShowTaskInput(value: boolean): void {
    this.showTaskInput.set(value);
  }

  /**
   * @function updateShowTaskUpdate
   * @description Protected method that update the TaskInput component for update task
   * @param {boolean} value The new state of the TaskInput
   * @returns {void}
   */
  protected updateShowTaskUpdate(value: boolean): void {
    this.showTaskUpdate.set(value);
  }


  // * TASK MANIPULATION * //
  /**
   * @function createTaskCard
   * @description Protected method that create a new Task and update the web interface
   * @param value The titled of the task 
   * @returns {void}
   */
  protected createTaskCard(value: string): void {
    this.taskService.create(value);
    this.taskList = this.taskService.index();
    this.updateShowTaskInput(false);
  }

  /**
   * @function updateCheckTask
   * @description Protected method that checks/unchecks a task
   * @param {number} taskId The primary key of the task
   * @returns {void}
   */
  protected updateCheckTask(taskId: number): void {
    const task = this.taskService.get(taskId);
    if(!task) {
      throw new Error(`Impossible de cocher la tâche : ${taskId} puisqu'elle n'existe pas.`);
    }

    const checkedTask = Task.fromInterface({
      id     : task.getId(),
      titled : task.getTitled(),
      checked: task.getChecked() ? false: true
    });
    this.taskService.update(checkedTask);
    this.taskList = this.taskService.index();
  }

  /**
   * @function handleUpdateTask
   * @description Protected method that start the task update
   * @param {number} value The primary key of the task
   * @returns {void}
   */
  protected handleUpdateTask(value: number): void {
    this.currenTaskUpdate = this.taskService.get(value);
    if(!this.createTaskCard) {
      throw new Error(`Impossible de mettre à jour la tâche ${value} puisqu'elle n'existe pas.`);
    }

    this.updateShowTaskUpdate(true);
  }

  /**
   * @function updateContentTask
   * @description Protected method that update the titled of a task
   * @param {number} updatedTask The task after update
   * @returns {void}
   */
  protected updateContentTask(updatedTask: Task): void {
    this.currenTaskUpdate = undefined;
    this.updateShowTaskUpdate(false);
    this.taskService.update(updatedTask);
    this.taskList = this.taskService.index();
  }

  /**
   * @function deleteTask
   * @description Protected method that deletes a task
   * @param {numbert} taskId The primary key of the task
   * @returns {void}
   */
  protected deleteTask(taskId: number): void {
    this.taskService.delete(taskId);
    this.taskList = this.taskService.index();
  }
}
