import { Component, effect, inject } from '@angular/core';
import { NavBar } from '../../components/nav-bar/nav-bar';
import { ProjectService } from '../../../domain/services/project.service';
import { toSignal } from '@angular/core/rxjs-interop';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectModel } from '../../../domain/entities/project.model';
import { EstablishmentService } from '../../../domain/services/establishment.service';

@Component({
  selector: 'app-projects.list',
  imports: [
    NavBar
  ],
  templateUrl: './projects.list.html',
  styleUrl: './projects.list.css',
})
export class ProjectsList {

  private activatedRoute = inject(ActivatedRoute);
  private establishmentService = inject(EstablishmentService);
  private projectService = inject(ProjectService);

  protected establishment = toSignal(
    this.establishmentService.get(this.activatedRoute.snapshot.params['id']),
    { initialValue: undefined }
  );
  protected projects = toSignal<ProjectModel[]>(
    this.projectService.indexByEstablishmentId(this.activatedRoute.snapshot.params['id']),
    { initialValue: undefined }
  );

  constructor() {
    effect(() => {
      console.log("Etablissement :");
      console.log(this.establishment());

      console.log("Liste des projets :")
      console.log(this.projects());
    });
  }

}
