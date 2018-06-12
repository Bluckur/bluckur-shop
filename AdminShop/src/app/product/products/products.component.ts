import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../api/product.service';
import { Product } from '../../models/product';

import { MatTableDataSource, MatPaginator, MatDialog } from '@angular/material';
import { ProductDetailComponent } from '../product-detail/product-detail.component';



@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  error: any;

  displayedColumns = ['id', 'name', 'description', 'imagePath', 'price', 'quantity', 'edit', 'delete'];
  dataSource : any;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private router: Router, private productService: ProductService,public dialog: MatDialog) { }

  ngOnInit() {
    //this.mockProduct();
    this.initTableDatasource();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  initTableDatasource(){
    this.dataSource = new MatTableDataSource(this.products);
  }

  getProducts(): void {
    this.productService
      .getProducts()
      .subscribe(
        products => (this.products = products),
        error => (this.error = error)
      )
  }

  delete(product: Product): void{
    console.log(product);
    const index: number= this.products.indexOf(product);
    if(index != -1){
      this.products.splice(index, 1);
    }
    console.log(this.products);
    this.initTableDatasource();
  }

  openDialog(product: Product): void {
    let dialogRef = this.dialog.open(ProductDetailComponent, {
      width: '250px',
      data: product
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      //this.animal = result;
    });
  }

  // mockProduct() {
  //   this.products = [
  //     { id: 1, name: 'T-shirt', description: 'Een skon tshirt jung', image: 'tshirt.jpg', price: 1, quantity: 999 },
  //     { id: 2, name: 'Hemd', description: 'Een skon hemd jung', image: 'hemd.jpg', price: 3, quantity: 999 },
  //     { id: 3, name: 'Broek', description: 'Een skon broek van spijker jung', image: 'broek.jpg', price: 10, quantity: 999 },
  //     { id: 4, name: 'Pet', description: 'Een pet van Kanye West', image: 'broek.jpg', price: 1, quantity: 999 },
  //     { id: 5, name: 'Boek', description: 'Een boek over de Tweede Wereldoorlog', image: 'boek.jpg', price: 9, quantity: 999 },
  //     { id: 6, name: 'Vliegticket', description: 'Een vliegticket naar Kroatië', image: 'vliegticket.jpg', price: 150, quantity: 999 },
  //     { id: 7, name: 'Mobiel', description: 'Een skon mobiel', image: 'mobiel.jpg', price: 10, quantity: 999 },
  //     { id: 8, name: 'Stoel', description: 'Een stoel met spijkers', image: 'stoel.jpg', price: 1, quantity: 999 },
  //     { id: 9, name: 'Whiteboard', description: 'Een whiteboard die niet wit is', image: 'whiteboard.jpg', price: 3, quantity: 999 },
  //     { id: 10, name: 'Stift', description: 'Een mooie multicolor stift', image: 'stift.jpg', price: 2, quantity: 999 }
  //   ];
  // }



  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}
