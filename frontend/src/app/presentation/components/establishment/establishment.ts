import { Component, input, output } from '@angular/core';
import { EstablishmentModel } from '../../../domain/entities/establishment.model';

@Component({
  selector: 'app-establishment',
  imports: [],
  templateUrl: './establishment.html',
  styleUrl: './establishment.css',
})
export class Establishment {

  readonly establishment = input.required<EstablishmentModel>();

  public clicked = output<number>(); 

  protected emit(): void {
    this.clicked.emit(this.establishment().id);
  }

}
