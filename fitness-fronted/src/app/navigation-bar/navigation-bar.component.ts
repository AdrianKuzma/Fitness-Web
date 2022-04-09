import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent {

  login$: Observable<boolean>;

  constructor(
    private authService: AuthService,
    private router: Router,
  ) {
    this.login$ = this.authService.login$;
  }

  logout(): void {
    this.authService.logout();
    this.router.navigateByUrl('/login');
  }

}
