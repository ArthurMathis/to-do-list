import { Component, effect, inject,  signal } from '@angular/core';
import { NotificationInterface } from '../../../core/notification.utils';
import { NotificationService } from '../../../domain/services/notification.service';

@Component({
  selector: 'app-notification',
  imports: [],
  templateUrl: './notification.html',
  styleUrl: './notification.css',
})
export class Notification {

  private notificationService = inject(NotificationService);

  protected visible = signal<boolean>(false);
  protected notification = signal<NotificationInterface|undefined>(undefined);
  
  constructor() {
    effect(() => {
      this.notification.set(this.notificationService.notification());

      if(this.notification()) {
        setTimeout(() => this.visible.set(true), 10);
      } else {
        this.visible.set(false);
      }
    });
  }

}
