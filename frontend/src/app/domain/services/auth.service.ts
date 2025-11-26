import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { BASE_API_URL } from "../../core/api.utils";
import { AuthRequest } from "../interfaces/auth.request";
import { BehaviorSubject, Observable, tap } from "rxjs";
import { AuthResponse } from "../interfaces/auth.response";

@Injectable({
    providedIn: 'root'
})
class AuthService {

    private readonly authUrl = `${BASE_API_URL}auth`;
    private readonly tokenAccess = "token";   
    private readonly refreshTokenAccess = "refreshToken";   

    private httpClient = inject(HttpClient);

    private isAuthSubject = new BehaviorSubject<boolean>(this.hasToken());
    readonly isAuthenticated$ = this.isAuthSubject.asObservable();

    // * REQUESTS * //

    login(authRequest: AuthRequest): Observable<AuthResponse> {
        return this.httpClient.post<AuthResponse>(this.authUrl, authRequest).pipe(
            tap((authResponse: AuthResponse) => {
                localStorage.setItem(this.tokenAccess, authResponse.token);
                if(authResponse.refreshToken) {
                    localStorage.setItem(this.refreshTokenAccess, authResponse.refreshToken);
                }
                this.isAuthSubject.next(true);
            })
        );
    } 

    logout(): void {
        localStorage.removeItem(this.tokenAccess);
        localStorage.removeItem(this.refreshTokenAccess);
        this.isAuthSubject.next(false);
    }

    // * GETTERS * //

    private getToken(): string|null {
        return localStorage.getItem(this.tokenAccess);
    }

    public hasToken(): boolean {
        return !!localStorage.getItem(this.tokenAccess);
    }

    private getRefreshToken(): string|null {
        return localStorage.getItem(this.refreshTokenAccess);
    }

}

export { AuthService };