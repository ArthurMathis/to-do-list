import { Injectable, signal } from "@angular/core";
import { NotificationInterface } from "../../core/notification.utils";

@Injectable({
    providedIn: "root"
})
class NotificationService {

    readonly timeout = 5000;

    notification = signal<NotificationInterface|undefined>(undefined);

    alert(notification: NotificationInterface) {
        this.notification.set(notification);

        setTimeout(() => {
            this.notification.set(undefined);
        }, this.timeout);
    }

}

export { NotificationService };