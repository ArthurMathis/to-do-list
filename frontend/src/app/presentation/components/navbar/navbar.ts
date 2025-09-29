import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {

  protected router = inject(Router);

  protected goHome(): void {
    this.router.navigate([ "/home" ]);
  }
  
  protected goTask(): void {
    this.router.navigate([ "/task" ]);
  }
}
