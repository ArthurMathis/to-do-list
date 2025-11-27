interface AuthRequest {
    email: string;
    password: string;
}
interface AuthResponse {
    token: string;
    refreshToken?: string;
}

export type { AuthRequest, AuthResponse };