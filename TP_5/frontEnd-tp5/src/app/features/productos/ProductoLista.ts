import { Component } from '@angular/core';
import { ProductoService } from '../../core/services/productoService';
import { Producto } from '../../shared/models/producto';
import { CommonModule } from '@angular/common';
import { timer, Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
    selector: 'app-lista-productos',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './productoLista.html'
})
export class ListaProductosComponent {

    productos$!: Observable<Producto[]>;

    constructor(private service: ProductoService) { }

    ngOnInit(): void {

        this.productos$ = timer(0, 5000).pipe(
            switchMap(() => this.service.getProductos())
        );

    }
}