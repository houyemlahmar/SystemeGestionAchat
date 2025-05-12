import { Component, OnInit } from '@angular/core';
import { HistoriqueService } from '../../services/historique.service';
import { HistoriqueAchat } from '../../models/HistoriqueAchat.model';

@Component({
  selector: 'app-historique-list',
  standalone: false,
  templateUrl: './historique-list.component.html',
  styleUrl: './historique-list.component.css'
})
export class HistoriqueListComponent implements OnInit {
  historique: HistoriqueAchat[] = [];
  filteredHistorique: HistoriqueAchat[] = [];
  filter = {
    fournisseurId: '',
    date: '',
    montant: ''
  };

  constructor(private historiqueAchatService: HistoriqueService) {}

  ngOnInit(): void {
    this.loadHistorique();
  }

  loadHistorique(): void {
    this.historiqueAchatService.getHistorique().subscribe((data) => {
      this.historique = data;
      this.filteredHistorique = data;
    });
  }

  applyFilter(): void {
    this.filteredHistorique = this.historique.filter((achat) => {
      return (
        (!this.filter.fournisseurId || achat.fournisseurId === +this.filter.fournisseurId) &&
        (!this.filter.date || achat.date === this.filter.date) &&
        (!this.filter.montant || achat.montant === +this.filter.montant)
      );
    });
  }
}
