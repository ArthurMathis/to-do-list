/**
 * @interface Converter
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
interface Converter<DTO, Model> {

    /**
     * Public method that converters a DTO into a Model
     * 
     * @param {DTO} dto The DTO
     * @returns {Model} The Model
     */
    fromDto(dto: DTO): Model;

    /**
     * Public method that converts a Model into a DTO
     * 
     * @param {Model} model The Model
     * @returns {DTO} The DTO
     */
    toDto(model: Model): DTO;

}

export type { Converter };