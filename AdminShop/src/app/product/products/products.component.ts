import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../api/product.service';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: any[];
  error: any;

  constructor(private router: Router, private productService: ProductService) { }

  ngOnInit() {
  }

  getProducts(): void {
    this.productService
      .getProducts()
      .subscribe(
        products => (this.products = products),
        error => (this.error = error)
      )
  }
}
