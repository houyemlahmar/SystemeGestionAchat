import { NgModule } from '@angular/core';
import { FournisseurListComponent } from './fournisseurs/fournisseur-list/fournisseur-list.component';
import { FournisseurFormComponent } from './fournisseurs/fournisseur-form/fournisseur-form.component';
import { CommandeListComponent } from './commandes/commande-list/commande-list.component';
import { CommandeFormComponent } from './commandes/commande-form/commande-form.component';
import { HistoriqueListComponent } from './historiques/historique-list/historique-list.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'home', component: FournisseurListComponent },
  { path: 'fournisseurs', component: FournisseurListComponent },
  { path: 'fournisseur/add', component: FournisseurFormComponent },
  { path: 'fournisseur/edit/:id', component: FournisseurFormComponent },
  { path: 'fournisseur-form', component: FournisseurFormComponent },
  { path: 'commandes', component: CommandeListComponent },
  { path: 'commande-form', component: CommandeFormComponent },
  { path: 'commande-form/:id', component: CommandeFormComponent },
  { path: 'historiques', component: HistoriqueListComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
