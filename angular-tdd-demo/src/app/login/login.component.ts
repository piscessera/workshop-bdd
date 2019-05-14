import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message: '';
  loginForm: FormGroup;
  login = {
    username: '',
    password: ''
  }

  constructor() {
    this.createForm();
  }

  ngOnInit() {
  }

  createForm(): void {
    this.loginForm = new FormGroup({
      'username': new FormControl(this.login.username, [
        Validators.required,
        Validators.maxLength(10)
      ]),      
      'password': new FormControl(this.login.password, [
        Validators.required,
        Validators.maxLength(10)
      ])
    });
  }

}
