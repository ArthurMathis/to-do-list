import { inject, Injectable } from "@angular/core";
import { BASE_API_URL } from "../../core/api.utils";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";
import { EstablishmentInterface } from "../interfaces/establishment.interface";
import { EstablishmentConverter } from "../converters/establishment/establishment.converter";
import { EstablishmentModel } from "../entities/establishment.model";

@Injectable({
    providedIn: "root"
})
class EstablishmentService {

    private httpClient = inject(HttpClient);
    private establishmentConverter = inject(EstablishmentConverter);

    public get(establishmentId: number): Observable<EstablishmentModel> {
        return this.httpClient.get<EstablishmentModel>(`${BASE_API_URL}home/establishments/${establishmentId}`).pipe(
            map((dictionnary) => {
                return this.establishmentConverter.fromDto(dictionnary);
            })
        );
    }

    public indexByUser(): Observable<EstablishmentModel[]> {
        return this.httpClient.get<EstablishmentInterface[]>(`${BASE_API_URL}home/establishments`).pipe(
            map((dictionnaries: EstablishmentInterface[]) => {
                return dictionnaries.map(obj => {
                    return this.establishmentConverter.fromDto(obj)
                })
            })
        );
    }

}

export { EstablishmentService };