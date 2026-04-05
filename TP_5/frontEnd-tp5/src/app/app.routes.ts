import { Routes } from '@angular/router';
import { ListaProductosComponent } from './features/productos/ProductoLista';

export const routes: Routes = [

  { path: 'producto', component: ListaProductosComponent },

  { path: '', redirectTo: 'producto', pathMatch: 'full' }

];