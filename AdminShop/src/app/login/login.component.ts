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
  error: string = "";
  loading = false;

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.authenticationService.logout();
  }

  login() {
    //console.log("username:" +  this.username + "  /  password:"+this.password)
    // this.authenticationService.login(this.username, this.password).subscribe(
    //   data => {
    //     // go page
    //     this.router.navigate["/products"];
    //   },
    //   error =>{
    //     // show error
    //     this.error=error;
    //     this.loading = false;
    //   }
    // );
    if (this.username == null || this.password == null) {
      console.log("empty");
      this.error = "Please fill in username and password";
    } else {
      localStorage.setItem('currentUserToken', this.username);
      this.router.navigate(['products']);
    }


  }
}
