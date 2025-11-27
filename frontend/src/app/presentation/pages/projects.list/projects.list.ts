import { Component, signal } from '@angular/core';
import { NavBar } from '../../components/nav-bar/nav-bar';

@Component({
  selector: 'app-projects.list',
  imports: [
    NavBar
  ],
  templateUrl: './projects.list.html',
  styleUrl: './projects.list.css',
})
export class ProjectsList {

  protected projects = signal(undefined);

}
