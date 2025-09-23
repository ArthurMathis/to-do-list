/**
 * @interface TaskInterface
 * @description Interface that represent a piece of the model Task 
 * 
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export default interface TaskInterface {
    id     : number,
    titled : string,
    checked: boolean
}