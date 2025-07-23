import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskPageComponent } from './components/task-page/task-page.component';

const routes: Routes = [
  {path:"", redirectTo: 'tasks', pathMatch: 'full' },
  {path:"tasks",component:TaskPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
