import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  error: string;

  constructor(
    private authService: AuthService,
    private router: Router,
  ) { }

  ngOnInit(): void { // main funkcia komponentu
    this.form = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }

  submit() {
    if (this.form.valid) {
      const { username, password } = this.form.value;
      
      // login na request na backend
      this.authService.login(username, password)
        .subscribe(() => this.router.navigateByUrl('/home'));
    }
  }

}
