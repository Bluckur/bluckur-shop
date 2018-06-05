import { Component, OnInit, Inject } from '@angular/core';
import { Purchase } from '../../models/purchase';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { PurchasesComponent } from '../purchases/purchases.component';

@Component({
  selector: 'app-purchase-detail',
  templateUrl: './purchase-detail.component.html',
  styleUrls: ['./purchase-detail.component.css']
})
export class PurchaseDetailComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<PurchasesComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Purchase) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
