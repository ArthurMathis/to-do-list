import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../domain/services/auth.service';

@Component({
  selector: 'app-nav-bar',
  imports: [
  ],
  templateUrl: './nav-bar.html',
  styleUrl: './nav-bar.css',
})
export class NavBar {

  private router = inject(Router);
  private authService = inject(AuthService);

  protected goHome(): void {
    this.router.navigate([ 'establishments' ]);
  }

  protected logout(): void {
    this.authService.logout();
    this.router.navigate([ 'login' ]);
  }

}
