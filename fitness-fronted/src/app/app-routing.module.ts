import { ExercisesComponent } from './exercises/exercises.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent} from './home-page/home-page.component'
import { TrainingComponent } from './training/training.component';
import { SupplementsComponent } from './supplements/supplements.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent},
  { path: 'exercises', component: ExercisesComponent},
  { path: 'training', component: TrainingComponent},
  { path: 'supplements', component: SupplementsComponent},
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
