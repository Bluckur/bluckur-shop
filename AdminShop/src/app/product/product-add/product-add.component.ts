import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from '../../api/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  product: Product = { id: null, name: "", description: "", imagePath: "", price: null, quantity: null };
  fileToUpload: File = null;

  constructor(private productsService: ProductService, private router: Router) { }
  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    this.product.imagePath = files.item(0).name.toString();
    console.log(files.item(0).name);
  }

  ngOnInit() {
  }

  addProduct() {
    this.productsService.addProduct(this.product).subscribe(
      data => {
        console.log("added product:");
        console.log(data);
        this.router.navigate(['products']);
      },
      error => {
        console.log("error");
        console.log(error);
      });
  }

}
