import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "cupaki"
  password = ""
  errorMessage = "Invalid credentials"
  invalidLogin = false


  //router
  //angular.giveMeRouter
  //Dependency incejction
  constructor(private router: Router, 
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit() {
  }

  handleLogin() {
    //if (this.username === "cupaki" && this.password === "1111")
    if (this.hardcodedAuthenticationService.authenticate(this.username, this.password)) {
      //redirect to welcome page
      this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
    }
    else {
      this.invalidLogin = true
    }
  }

  handleBasicAuthLogin() {
    //if (this.username === "cupaki" && this.password === "1111")
    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome', this.username])
            console.log('treba welcome')
            this.invalidLogin = false
          },
          error => {
            console.log(error)
            console.log('nece majmune')
            this.invalidLogin = true
          }
        )
      //redirect to welcome page
    
  }

  handleJWTAuthLogin() {
    this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome', this.username])
            console.log('treba welcome')
            this.invalidLogin = false
          },
          error => {
            console.log(error)
            console.log('nece majmune')
            this.invalidLogin = true
          }
        )
      //redirect to welcome page
    
  }


}
