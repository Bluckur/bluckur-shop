import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 



import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule, MatToolbar, MatToolbarModule, MatIconModule } from '@angular/material';
import { MatInputModule } from '@angular/material/input';




import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './product/products/products.component';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { PurchasesComponent } from './purchase/purchases/purchases.component';
import { PurchaseDetailComponent } from './purchase/purchase-detail/purchase-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductService } from './api/product.service';
import { PurchaseService } from './api/purchase.service';
import { CustomerService } from './api/customer.service';
import { HeaderComponent } from './header/header.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProductsComponent,
    ProductDetailComponent,
    PurchasesComponent,
    PurchaseDetailComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule, MatCheckboxModule, MatInputModule, MatToolbarModule, MatIconModule
  ],
  providers: [ProductService, PurchaseService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
