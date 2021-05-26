import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

export class Product {
  constructor(
    public idProduit: number,
    public name: string,
    public description: string,
    public prix: number,
    public prix_achat: number,
    public image: string,
    public qantite: number,
    public category,

  ) {
  }
}




@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[];
  product: Product;
  constructor(
    private httpClient: HttpClient, private productservice: ProductService
  ) { }

  ngOnInit(): void {
    this.getProducts();
  }

  // getProducts() {
  //   this.httpClient.get<any>('http://localhost:8088/allProduits').subscribe(
  //     response => {
  //       console.log(response);
  //       this.products = response;
  //     }
  //   );
  // }

  getProducts() {
    this.productservice.getProduct().subscribe(

      response => {
        console.log(response);
        this.products = response;

      }
    )
  }


}
