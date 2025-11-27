class EstablishmentModel {

    constructor(
        private _id: number, 
        private _name: string,
        private _city: string,
        private _postCode: string,
        private _projectsId: number[],
        private _usersId: number[],
        private _createdAt: string
    ) {}

    // * GETTERS * // 
    get id(): number {
        return this._id;
    }

    get name(): string {
        return this._name;
    }

    get city(): string {
        return this._city;
    }

    get postCode(): string {
        return this._postCode;
    }

    get projectsId(): number[] {
        return this._projectsId;
    }

    get usersId(): number[] {
        return this._usersId;
    }

    get createdAt(): string {
        return this._createdAt;
    }

    // * SETTERS * //
    set id(value: number) {
        this._id = value;
    }

    set name(value: string) {
        this._name = value;
    }

    set city(value: string) {
        this._city = value;
    }

    set postCode(value: string) {
        this._postCode = value;
    }

    set projectsId(value: number[]) {
        this._projectsId = value;
    }

    set usersId(value: number[]) {
        this._usersId = value;
    }

    set createdAt(value: string) {
        this._createdAt = value;
    }

}

export { EstablishmentModel };