import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../api/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  error: "";
  loading = false;

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.authenticationService.logout();
  }

  login(){
    console.log("username:" +  this.username + "  /  password:"+this.password)
    // this.authenticationService.login(this.username, this.password).subscribe(
    //   data => {
    //     // go page
    //     this.router.navigate["/login"];
    //   },
    //   error =>{
    //     // show error
    //     this.error=error;
    //     this.loading = false;
    //   }
    // );
  }
}
