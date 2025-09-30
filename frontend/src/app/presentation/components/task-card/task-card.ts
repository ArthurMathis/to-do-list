import { Component, input, output } from '@angular/core';
import { NgClass } from '@angular/common';
import { Task } from '../../../domain/models/task.model';

@Component({
  selector: 'app-task-card',
  imports: [
    NgClass
  ],
  templateUrl: './task-card.html',
  styleUrl: './task-card.css'
})
export class TaskCard {

  public task = input.required<Task>();

  protected taskCheck  = output<number>();
  protected taskUpdate = output<number>();
  protected taskDelete = output<number>();

  protected handleCheck(): void {
    this.taskCheck.emit(this.task().Id);
  }

  protected handleUpdate(): void {
    this.taskUpdate.emit(this.task().Id);
  }

  protected handleDelete(): void {
    this.taskDelete.emit(this.task().Id);
  }
}