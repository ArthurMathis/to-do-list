interface EstablishmentInterface {
    id: number;
    name: string;
    city: string;
    postCode: string;
    projectsId: number[];
    usersId: number[];
    createdAt: string;
}

interface EstablishmentCreateInterface {
    name: string;
    city: string;
    postCode: string;
}

interface EstablishmentUpdateIntefrace {
    id: number;
    name: string;
    city: string;
    postCode: string;
    projectsId: number[];
    usersId: number[];
}

export type { 
    EstablishmentInterface,
    EstablishmentCreateInterface,
    EstablishmentUpdateIntefrace
}