import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { environment } from '../../environments/environment';



@Injectable()
export class CustomerService {

  private customerApiUrl = environment.customerApiURL;

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }


  getCustomerInfo(publicKeyHash : string){
    return this.http.get(this.customerApiUrl + publicKeyHash, this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

}
