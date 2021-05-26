import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FriendComponent } from './friend/friend.component';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component'

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'friend', component: FriendComponent },
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
