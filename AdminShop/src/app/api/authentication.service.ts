import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

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

  // login(username, password) {
  //    let body = "?identifier=" + username + "&password=" + password;
  //   // let params = new URLSearchParams();
  //   // params.set('identifier', username);
  //   // params.set('password', password);
  //   // let headers = new Headers();
  //   // headers.append('Content-Type', 'application/json');

  //   return this.http.get(this.authenticationApiUrl + body, this.httpOptions
  //   ).map(token => {
  //     console.log(token);
  //     // login successful if there's a jwt token in the response
  //     // store user details and jwt token in local storage to keep user logged in between page refreshes
  //     localStorage.setItem('token', JSON.stringify(token));

  //   })
  //     .catch((error: any) => this.handleError(error));;
  // }

  login(username, password) {
    let body = "?identifier=" + username + "&password=" + password;

    return this.http.get("http://127.0.0.1:8080/authentication/login?identifier=stan&password=QWERTY12345", this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));
  }

  getUser() {
    return JSON.parse(localStorage.getItem("token"));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('token');
  }

  private handleError(error: Response) {
    return Observable.throw("error:" + error.text);
  }

}
