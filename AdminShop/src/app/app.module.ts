import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './product/products/products.component';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { PurchasesComponent } from './purchase/purchases/purchases.component';
import { PurchaseDetailComponent } from './purchase/purchase-detail/purchase-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductService } from './api/product.service';
import { PurchaseService } from './api/purchase.service';
import { CustomerService } from './api/customer.service';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {DataSource} from '@angular/cdk/table';
import { CdkTableModule} from '@angular/cdk/table';
import { AuthenticationService } from './api/authentication.service';
import { AuthGuard } from './api/auth.guard';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProductsComponent,
    ProductDetailComponent,
    ProductAddComponent,
    PurchasesComponent,
    PurchaseDetailComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MaterialModule,
  ],
  entryComponents: [ProductsComponent, ProductDetailComponent],
  providers: [AuthGuard, ProductService, PurchaseService, CustomerService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
