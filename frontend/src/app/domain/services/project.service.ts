import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from "@angular/core";
import { ProjectModel } from "../entities/project.model";
import { map, Observable } from "rxjs";
import { BASE_API_URL } from '../../core/api.utils';
import { ProjectInterface } from '../interfaces/project.interface';
import { ProjectConverter } from '../converters/project/project.converter';

@Injectable({
    providedIn: "root"
})
class ProjectService {

    private httpClient = inject(HttpClient);
    private projectConverter = inject(ProjectConverter);

    indexByEstablishmentId(establishmentId: number): Observable<ProjectModel[]> {
        return this.httpClient.get<ProjectModel[]>(`${BASE_API_URL}home/establishments/${establishmentId}/projects`).pipe(
            map((projects: ProjectInterface[]) => {
                return projects.map(obj => {
                    return this.projectConverter.fromDto(obj); 
                })
            })
        );
    }

}

export { ProjectService };