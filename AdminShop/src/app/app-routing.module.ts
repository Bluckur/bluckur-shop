import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductsComponent } from './product/products/products.component';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { PurchasesComponent } from './purchase/purchases/purchases.component';
import { PurchaseDetailComponent } from './purchase/purchase-detail/purchase-detail.component';
import { LoginComponent } from  './login/login.component';
import { AuthGuard } from './api/auth.guard';



const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'products', component: ProductsComponent, canActivate: [AuthGuard] },
  { path: 'product/:id', component: ProductDetailComponent , canActivate: [AuthGuard]},
  { path: 'addproduct', component: ProductAddComponent , canActivate: [AuthGuard]},
  { path: 'purchases', component: PurchasesComponent, canActivate: [AuthGuard] },
  { path: 'purchases/:id', component: PurchaseDetailComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }