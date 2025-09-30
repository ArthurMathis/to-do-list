/**
 * @class Task
 * @classdesc The Task Model
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export class Task {

    private id: number = 0;
    private titled: string = "";
    private checked: boolean = false;

    get Id(): number {
        return this.id;
    }

    get Titled(): string {
        return this.titled;
    }

    get Checked(): boolean {
        return this.checked;
    }

    /**
     * @function 
     * @description Public method that duplicates the Task
     * @returns {Task} The duplicated Task
     */
    copy(): Task {
        return Object.assign(new Task(), this);
    }
}