import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FournisseurListComponent } from './fournisseurs/fournisseur-list/fournisseur-list.component';
import { FournisseurFormComponent } from './fournisseurs/fournisseur-form/fournisseur-form.component';
import { CommandeListComponent } from './commandes/commande-list/commande-list.component';
import { CommandeFormComponent } from './commandes/commande-form/commande-form.component';
import { LigneListComponent } from './lignes/ligne-list/ligne-list.component';
import { LigneFormComponent } from './lignes/ligne-form/ligne-form.component';
import { HistoriqueListComponent } from './historiques/historique-list/historique-list.component';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    FournisseurListComponent,
    FournisseurFormComponent,
    CommandeListComponent,
    CommandeFormComponent,
    LigneListComponent,
    LigneFormComponent,
    HistoriqueListComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch()),
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
