import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatPaginator, MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';
import { PurchaseService } from '../../api/purchase.service';
import { Purchase } from '../../models/purchase';
import { PurchaseDetailComponent } from '../purchase-detail/purchase-detail.component';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.css']
})
export class PurchasesComponent implements OnInit {
  purchases: Purchase[];
  error: any;


  displayedColumns = ['id', 'approved', 'processes', 'total_amount', 'timestamp', 'edit', 'delete'];
  dataSource: any;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private router: Router, private purchaseService: PurchaseService, public dialog: MatDialog) { }

  ngOnInit() {
    this.mockProduct();
    this.initTableDatasource();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  initTableDatasource() {
    this.dataSource = new MatTableDataSource(this.purchases);
  }
  delete(purchase: Purchase): void {
    console.log(purchase);
    const index: number = this.purchases.indexOf(purchase);
    if (index != -1) {
      this.purchases.splice(index, 1);
    }
    console.log(this.purchases);
    this.initTableDatasource();
  }

  openDialog(purchase: Purchase): void {
    let dialogRef = this.dialog.open(PurchaseDetailComponent, {
      width: '250px',
      data: purchase
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }

  mockProduct() {
    this.purchases = [
      { id: 1, approved: true , processes: true , total_amount: 10, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 2, approved: true , processes: false , total_amount: 5, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 3, approved: true , processes: false , total_amount: 14, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 4, approved: false , processes: true , total_amount: 6, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 5, approved: false , processes: true , total_amount: 99, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 6, approved: true , processes: true , total_amount: 10, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 7, approved: false , processes: true , total_amount: 55, timestamp: new Date("February 4, 2016 10:13:00")},
      { id: 8, approved: false , processes: false , total_amount: 40, timestamp: new Date("February 4, 2016 10:13:00")}
    ];
  }



  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
