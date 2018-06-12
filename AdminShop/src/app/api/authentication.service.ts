import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationService {

  private authenticationApiUrl = environment.autheticationApiUrl;

  constructor(private http: HttpClient, private router: Router) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  login(username, password) {
    // let body = "username=" + username + "&password=" + password;

    return this.http.post<any>(this.authenticationApiUrl, { username: username, password: password }).map(user => {
      // login successful if there's a jwt token in the response
      console.log("connection works");
      if (user && user.token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUserToken', JSON.stringify(user));
      }
      return user;
    });
  }

  getUser() {
    return JSON.parse(localStorage.getItem("currentUserToken"));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUserToken');
  }

}
