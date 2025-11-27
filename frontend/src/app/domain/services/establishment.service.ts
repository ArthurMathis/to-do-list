import { inject, Injectable } from "@angular/core";
import { BASE_API_URL } from "../../core/api.utils";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";
import { Establishment } from "../../presentation/components/establishment/establishment";
import { EstablishmentInterface } from "../interfaces/establishment.interface";
import { EstablishmentConverter } from "../converters/establishment/establishment.converter";
import { EstablishmentModel } from "../entities/establishment.model";

@Injectable({
    providedIn: "root"
})
class EstablishmentService {

    private readonly authUrl = `${BASE_API_URL}home/`;

    private httpClient = inject(HttpClient);
    private establishmentConverter = inject(EstablishmentConverter);

    /**
     * Public method that returns the user's list of establishments
     * 
     * @returns {Observable<EstablishmentModel[]>} The user's list of establishments
     */
    public indexByUser(): Observable<EstablishmentModel[]> {
        const response = this.httpClient.get<EstablishmentInterface[]>(`${this.authUrl}establishments`).pipe(
            map((establishments: EstablishmentInterface[]) => {
                return establishments.map(obj => {
                    return this.establishmentConverter.fromDto(obj)
                })
            })
        );
        console.log(response);
        return response;
    }

}

export { EstablishmentService };