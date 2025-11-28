import { inject, Injectable } from "@angular/core";
import { AuthService } from "../../domain/services/auth.service";
import { Router } from "@angular/router";

@Injectable({
    providedIn: "root"
})
class AuthGuard  {

    private router = inject(Router);
    private authService = inject(AuthService);

    private access(): boolean {
        if(!this.authService.hasToken()) {
            this.router.navigate([ '/login' ]);
            return false;
        }

        return true;
    }

    canActivate(): boolean {
        return this.access();
    }

    canActivateChild(): boolean {
        return this.access();
    }

}

export { AuthGuard };