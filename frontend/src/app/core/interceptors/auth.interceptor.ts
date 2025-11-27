import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../../domain/services/auth.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
    const authService = inject(AuthService);
    const token = authService.getToken();

    console.log("➡️ Interceptor - Request URL:", req.url);
    console.log("➡️ Interceptor - Token:", token);

    // Pas de token → on ne modifie pas la requête
    if (!token || req.url.includes('/auth')) {
        return next(req);
    }

    // Ajouter le token
    const cloned = req.clone({
        setHeaders: {
            Authorization: `Bearer ${token}`
        }
    });

    return next(cloned);
};
