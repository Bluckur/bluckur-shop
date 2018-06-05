import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import "rxjs/Rx";
import { Product } from '../models/product';
import { environment } from '../../environments/environment';


@Injectable()
export class ProductService {

  private productsUrl = environment.productApiURL;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };

  constructor(private http: HttpClient) { }

  getProducts(): Observable<any[]> {
    return this.http.get(this.productsUrl, this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));
  }

  getProduct(id: number): Observable<any> {
    return this.http.get(this.productsUrl + id, this.httpOptions)
      .map((res: Response) => res)
      .catch((error: any) => this.handleError(error));
  }

  addProduct(product: Product) {
    return this.http
      .post<Product>(this.productsUrl + "add", product, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  updateProduct(product: Product) {
    let body = JSON.stringify(product);
    return this.http.put(this.productsUrl + "update", body, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  deleteProduct(productId: number) {
    return this.http.delete(this.productsUrl + "delete/" + productId, this.httpOptions)
      .catch((error: any) => this.handleError(error));
  }

  private handleError(error: Response) {  
    return Observable.throw(error.statusText);
  }

}
