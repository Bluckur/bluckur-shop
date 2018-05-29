import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { PRODUCTS } from '../mockproducts';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  product: Product = {id : null, name: "", description: "", image: "", price: null, quantity: null};
  constructor() { }

  ngOnInit() {
  }

  addProduct(){
    //TODO: RESTcall add product
    //PRODUCTS.push(product);
    console.log("addProduct");

    console.log(this.product);
  }

}
