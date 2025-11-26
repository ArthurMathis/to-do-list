export class Builder<T> {

    private obj: Partial<T> = {};

    set<K extends keyof T>(key: K, value: T[K]): this {
        this.obj[key] = value;
        return this;
    }

    build(): T {
        return this.obj as T;
    }

}
