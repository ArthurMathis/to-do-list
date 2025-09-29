import TaskInterface from "../utils/task.interface";

/**
 * @class Task
 * @classdesc The Task Model
 * 
 * @author Arthur MATHIS <arthur.mathis@diaconat-mulhouse.fr>
 */
export default class Task {

    /**
     * @var {number} id The primary key of the task
     */
    protected id: number;
    /**
     * @var {string} titled The titled of the task
     */
    protected titled: string;
    /**
     * @var {boolean} checked If the task is done
     */
    protected checked: boolean;

    /**
     * @constructor
     * @param {number} id  The primary key of the task
     * @param {string} titled The titled of the task
     * @param {boolean} checked If the task is done
     */
    public constructor(
        id: number, 
        titled: string, 
        checked: boolean
    ) {
        this.id      = id;
        this.titled  = titled;
        this.checked = checked;
    }

    public getId(): number { return this.id; }
    public getTitled(): string { return this.titled; }
    public getChecked(): boolean { return this.checked; }

    /**
     * @function fromInterface
     * @param {TaskInterface} task The interface that contains the task data
     * @returns {Task} The new task builded from the interface 
     */
    public static fromInterface(task: TaskInterface): Task {
        return new Task(
            task.id,
            task.titled,
            task.checked
        );
    }

    /**
     * @function copy 
     * @description Public method that copy the task
     * @returns {Task} 
     */
    public copy(): Task {
        return new Task(
            this.getId(),
            this.getTitled(),
            this.getChecked()
        )
    }
}