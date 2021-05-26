import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './products/products.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[];

  constructor(private http: HttpClient) { }

  getProduct(): Observable<Product[]> {

    return this.http.get<Product[]>('http://localhost:8088/allProduits');
  }
}
