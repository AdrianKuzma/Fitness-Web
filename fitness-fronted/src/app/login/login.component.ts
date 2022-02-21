import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  error;
  

  constructor(private authService: AuthService) { }

  ngOnInit(): void { // main funkcia komponentu
    this.form = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }

  submit() {
    
    if (this.form.valid) {
      
      // login na request na backend
      this.authService.login(this.form.value.username, this.form.value.password).subscribe();
      
    }
  }

}
