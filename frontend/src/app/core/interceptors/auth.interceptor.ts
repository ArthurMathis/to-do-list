import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../../domain/services/auth.service';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { NotificationService } from '../../domain/services/notification.service';
import { NotificationCriticalLevel, Notificationicon } from '../notification.utils';

export const authInterceptor: HttpInterceptorFn = (req, next) => {

    const router = inject(Router);
    const notificationService = inject(NotificationService);
    
    const authService = inject(AuthService);
    const token = authService.getToken();

    console.log("➡️ Interceptor - Request URL:", req.url);
    console.log("➡️ Interceptor - Token:", token);

    if (!token || req.url.includes('/auth')) {
        return next(req);
    }

    const cloned = req.clone({
        setHeaders: {
            Authorization: `Bearer ${token}`
        }
    });

    return next(cloned).pipe(
        catchError(err => {
            if(err.status === 401) {
                console.warn("⛔ Token expiré → redirection vers login");
                
                notificationService.alert({
                    message : "Votre session a expirée. Vous allez être redirigé vers le login.",
                    critical: NotificationCriticalLevel.ERROR,
                    mode    : undefined,
                    icon    : Notificationicon.ERROR
                });

                authService.logout();
                router.navigate([' /login ']);
            }

            return throwError(() => err);
        })
    );
};
