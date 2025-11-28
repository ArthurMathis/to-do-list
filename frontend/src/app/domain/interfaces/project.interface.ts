interface ProjectInterface {
    id: number;
    title: string;
    description: string;
    establihsmentId: number;
    tasksId: number[];
    createdAt: string;
}

export type { ProjectInterface };