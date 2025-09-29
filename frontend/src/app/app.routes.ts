import { Home } from './presentation/pages/home/home';
import { Routes } from '@angular/router';
import { NotFound } from './presentation/pages/not-found/not-found';
import { TaskInput } from './presentation/pages/task-input/task-input';

export const routes: Routes = [
    //// HOME //// 
    {
        path      : "",
        redirectTo: "home",
        pathMatch : "full"
    }, 
    {
        path     : "home",
        component: Home
    }, 
    //// TASK ////
    {
        path: "task",
        children : [
            {
                path: ":id",
                component: TaskInput
            },

        ]
    },
    //// NOT FOUND ////
    {
        path     : "**",
        component: NotFound
    }
];
