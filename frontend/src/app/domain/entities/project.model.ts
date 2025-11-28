class ProjectModel {

    constructor(
        private _id: number,
        private _title: string,
        private _description: string,
        private _establihsmentId: number,
        private _tasksId: number[],
        private _createdAt: string
    ) {}

    // * GETTERS * //
    get id(): number {
        return this._id;
    }

    get title(): string {
        return this._title;
    }

    get description(): string {
        return this._description;
    }

    get establihsmentId(): number {
        return this._establihsmentId;
    }

    get tasksId(): number[] {
        return this._tasksId;
    }

    get createdAt(): string {
        return this._createdAt;
    }

    // * SETTERS * //
    set id(value: number) {
        this._id = value;
    }

    set title(value: string) {
        this._title = value;
    }

    set description(value: string) {
        this._description = value;
    }

    set establihsmentId(value: number) {
        this._establihsmentId = value;
    }

    set tasksId(value: number[]) {
        this._tasksId = value;
    }

    set createdAt(value: string) {
        this._createdAt = value;
    }

}

export { ProjectModel }