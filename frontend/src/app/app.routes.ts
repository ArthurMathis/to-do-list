import { Routes } from '@angular/router';
import { EstablishmentsList } from './presentation/pages/establishments.list/establishments.list';
import { NotFound } from './presentation/pages/not-found/not-found';
import { Login } from './presentation/pages/login/login';
import { AuthGuard } from './core/guard/auth.guard';

export const routes: Routes = [
    {
        path: "login",
        component: Login
    },
    {
        path: "",
        canActivate: [ AuthGuard ],
        canActivateChild: [ AuthGuard ],
        children: [
            {
                path: "",
                pathMatch: "full",
                redirectTo: "establishments"
            },
            {
                path: "establishments",
                component: EstablishmentsList,
                
            }, 
            
        ]
    },
    {
        path: "**",
        component: NotFound
    }
];
