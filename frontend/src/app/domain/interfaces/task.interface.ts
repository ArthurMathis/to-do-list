/**
 * @interface TaskInterface
 * @description Interface that represent a piece of the model Task 
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export interface TaskInterface {
    id     : number,
    titled : string,
    checked: boolean
}

/**
 * @interface TaskInterface
 * @description Interface that represent a piece of the model Task 
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export interface CreateTaskInterface {
    titled: string
}