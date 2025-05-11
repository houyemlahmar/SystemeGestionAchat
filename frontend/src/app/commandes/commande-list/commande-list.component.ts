import { Component, OnInit } from '@angular/core';
import { CommandeAchat } from '../../models/CommandeAchat.model';
import { CommandeService } from '../../services/commande.service';

@Component({
  selector: 'app-commande-list',
  standalone: false,
  templateUrl: './commande-list.component.html',
  styleUrl: './commande-list.component.css'
})
export class CommandeListComponent implements OnInit {
  commandes: CommandeAchat[] = [];

  constructor(private commandeService: CommandeService) {}

  ngOnInit(): void {
    this.loadCommandes();
  }

  loadCommandes(): void {
    this.commandeService.getAll().subscribe((data) => {
      this.commandes = data;
    });
  }

  deleteCommande(id: number | undefined): void {
    if (id === undefined) {
      console.error('Commande ID is undefined. Cannot delete.');
      return;
    }

    if (confirm('Êtes-vous sûr de vouloir supprimer cette commande ?')) {
      this.commandeService.delete(id).subscribe(() => {
        this.loadCommandes();
      });
    }
  }
}