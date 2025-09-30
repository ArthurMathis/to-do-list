/**
 * @abstract
 * @interface Converter
 * @description Interface that represent a Model-ModelInterface converter
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export interface Converter<Model, ModelInterface> {

    /**
     * @function fromModel
     * @description Public method that converts a model into an interface
     * @param {Model} model The model to convert
     * @returns {ModelInterface} The interface after conversion 
     */
    fromModel(model: Model): ModelInterface;
    
    /**
     * @function fromModel
     * @description Public method that converts an interface into a model
     * @param {ModelInterface} modelInterface The interface to convert
     * @returns {Model} The model after conversion 
     */
    fromInterface(modelInterface: ModelInterface): Model;
}