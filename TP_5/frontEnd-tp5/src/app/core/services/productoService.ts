import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../../shared/models/producto';

@Injectable({ providedIn: 'root' })
export class ProductoService {

    private apiUrl = 'http://localhost:8080/api/productos';

    constructor(private http: HttpClient) { }

    // Retorna un Observable (flujo de datos asincrónico)
    getProductos(): Observable<Producto[]> {
        return this.http.get<Producto[]>(this.apiUrl);
    }
}