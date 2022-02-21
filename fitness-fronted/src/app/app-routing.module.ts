import { ExercisesComponent } from './exercises/exercises.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent} from './home-page/home-page.component'
import { TrainingComponent } from './training/training.component';
import { SupplementsComponent } from './supplements/supplements.component';
import { ArticleComponent } from './article/article.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FavoritesComponent } from './favorites/favorites.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent},
  { path: 'exercises', component: ExercisesComponent},
  { path: 'training', component: TrainingComponent},
  { path: 'article', component: ArticleComponent},
  { path: 'supplements', component: SupplementsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'favorites', component: FavoritesComponent},
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
