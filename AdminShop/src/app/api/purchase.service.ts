import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { environment } from '../../environments/environment';
import { Purchase } from '../models/purchase';

@Injectable()
export class PurchaseService {

  private purchaseApiUrl = environment.purchaseApiURL;


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  getPurchases() {
    return this.http.get(this.purchaseApiUrl, this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));

  }

  getPurchase(purchaseId: number) {
    return this.http.get(this.purchaseApiUrl + purchaseId, this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));
  }

  addPurchase(purchase: Purchase) {
    //let body = JSON.stringify(purchase);
    //return this.http.post(this.purchaseApiUrl + "add", body, this.httpOptions);

    return this.http
      .post<Purchase>(this.purchaseApiUrl + "add", purchase, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  updatePurchase(purchase: Purchase) {
    let body = JSON.stringify(purchase);
    return this.http.put(this.purchaseApiUrl + "update", body, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  deletePurchase(purchaseId : number) {
    return this.http.delete(this.purchaseApiUrl + "delete/" + purchaseId, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

}
