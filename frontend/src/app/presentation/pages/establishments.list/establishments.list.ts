import { Component, inject, Signal } from '@angular/core';
import { NavBar } from "../../components/nav-bar/nav-bar";
import { Establishment } from "../../components/establishment/establishment";
import { EstablishmentService } from '../../../domain/services/establishment.service';
import { toSignal } from '@angular/core/rxjs-interop';
import { EstablishmentModel } from '../../../domain/entities/establishment.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-establishments.list',
  imports: [NavBar, Establishment],
  templateUrl: './establishments.list.html',
  styleUrl: './establishments.list.css',
})
export class EstablishmentsList {

  private establishmentService = inject(EstablishmentService);
  private router = inject(Router);

  protected establishments: Signal<EstablishmentModel[]> = toSignal(this.establishmentService.indexByUser(), {
    initialValue: []
  });

  protected navigate(establishmentId: number): void {
    this.router.navigate([ `projects/${establishmentId}` ]);
  }

}
