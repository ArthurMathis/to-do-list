import { Component, inject, signal } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../../domain/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  private readonly regex = "";

  private formBuilder = inject(FormBuilder);
  private authService = inject(AuthService);
  private router = inject(Router);

  protected loginError = signal<string|undefined>(undefined);
  protected formGroup = this.formBuilder.group({
    email: [ 
      "", 
      [ Validators.required, Validators.email ] 
    ],
    password: [ 
      "", 
      [ Validators.required, Validators.pattern(this.regex) ] 
    ]
  });

  protected handleSubmit(event: Event): void {
    event.preventDefault();

    const formData = this.formGroup.value;
    const authRequest = {
      email   : formData.email!,
      password: formData.password!
    };

    this.authService.login(authRequest).subscribe({
      next: (res) => {
        console.log(`✅ Authentification réussie avec le Token : ${res.token}`);
        this.loginError.set(undefined);
        this.router.navigate([ '/establishments' ]);
      },
      error: (err) => {
        let errorMessage: string;
        switch(err.status) {
          case 403:
            errorMessage ="Authentification incorrecte. Verifiez vos identifiants et recommencez.";          
            break;

          case 404:
            errorMessage ="Service temporairement indisponible. Si le problème persiste, contactez le support.";          
            break;

          case 500: 
            errorMessage ="Dysonfictonnment du service. Si le problème persiste, contactez le support.";          
            break;

          default: errorMessage = "Une erreur inconnue est survenue. Veuillez réessayer plus tard. Si le problème persiste, contactez le support.";
        }

        console.error(`❌ Login error : ${err.message}`);
        this.loginError.set(errorMessage);
      }
    });
  }

}
