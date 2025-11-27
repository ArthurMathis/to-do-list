import { Injectable } from "@angular/core";
import { Builder } from "../../../core/builder";
import { EstablishmentModel } from "../../entities/establishment.model";
import { EstablishmentInterface } from "../../interfaces/establishment.interface";
import { Converter } from "../converter";

@Injectable({
    providedIn: "root"
})
class EstablishmentConverter implements Converter<EstablishmentInterface, EstablishmentModel> {

    fromDto(dto: EstablishmentInterface): EstablishmentModel {
        return new Builder<EstablishmentModel>()
            .set("id", dto.id)
            .set("name", dto.name)
            .set("city", dto.city)
            .set("postCode", dto.postCode)
            .set("projectsId", dto.projectsId)
            .set("usersId", dto.usersId)
            .set("createdAt", dto.createdAt)
            .build();
    }
    
    toDto(model: EstablishmentModel): EstablishmentInterface {
        return {
            id        : model.id,
            name      : model.name,
            city      : model.city,
            postCode  : model.postCode,
            projectsId: model.projectsId,
            usersId   : model.usersId,
            createdAt : model.createdAt 
        };
    }
}

export { EstablishmentConverter };