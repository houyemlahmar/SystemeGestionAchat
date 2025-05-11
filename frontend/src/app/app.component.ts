import { Component } from '@angular/core';
import { Fournisseur } from './models/Fournisseur.model';

@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AchatFournisseur-Frontend';
  
  selectedFournisseur: Fournisseur | null = null;

  onSelectFournisseur(fournisseur: Fournisseur) {
    this.selectedFournisseur = fournisseur;
  }
}
