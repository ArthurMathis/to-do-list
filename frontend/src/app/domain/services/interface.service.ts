import { Observable } from "rxjs";

/**
 * @abstract
 * @interface Service
 * @description Interface that represent service interface
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export interface Service<Model, ModelInterface, CreateModelInterface> {

    /**
     * @function index 
     * @description Public method that returns the list of model
     * @returns {Observable<Model[]>} The list fo model
     */
    index(): Observable<Model[]>;

    /**
     * @function get
     * @description Public method taht returns a model from its primary key
     * @param {number} id The model primary key
     * @returns {Observable<Model>} The model
     */
    get(id: number): Observable<Model>;

    /**
     * @function create
     * @description Public method that creates a new model
     * @param {CreateModelInterface} CreateModelInterface The interface that contains the pieces of data of the model
     * @returns {Observable<void>} 
     */
    create(CreateModelInterface: CreateModelInterface): Observable<void>;

    /**
     * @function update
     * @description Public method that updates a model 
     * @param {ModelInterface} modelInterface The interface that contains the pieces of data of the model
     * @returns {Observable<void>} 
     */
    update(modelInterface: ModelInterface): Observable<void>;

    /**
     * @function delete
     * @description Public method that deletes a model from its primary key
     * @param {number} id The primary key of the mode
     * @returns {Observable<void>}
     */
    delete(id: number): Observable<void>;
}