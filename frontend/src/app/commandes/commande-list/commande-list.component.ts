import { Component, OnInit } from '@angular/core';
import { CommandeAchat } from '../../models/CommandeAchat.model';
import { CommandeService } from '../../services/commande.service';
import { FournisseurService } from '../../services/fournisseur.service';

@Component({
  selector: 'app-commande-list',
  standalone: false,
  templateUrl: './commande-list.component.html',
  styleUrl: './commande-list.component.css'
})
export class CommandeListComponent implements OnInit {
  commandes: CommandeAchat[] = [];
  fournisseurs: any[] = []; // Liste des fournisseurs
  commandeSelectionnee: CommandeAchat | null = null; // Commande sélectionnée pour afficher les détails

  constructor(
    private commandeService: CommandeService,
    private fournisseurService: FournisseurService
  ) {}

  ngOnInit(): void {
    this.loadCommandes();
    this.loadFournisseurs();
  }

  loadCommandes(): void {
    this.commandeService.getAll().subscribe((data) => {
      this.commandes = data;
    });
  }

  loadFournisseurs(): void {
    this.fournisseurService.getFournisseurs().subscribe((data) => {
      this.fournisseurs = data;
    });
  }
  getFournisseurNom(fournisseurId: number | undefined): string {
    const fournisseur = this.fournisseurs.find((f) => f.id === fournisseurId);
    return fournisseur ? fournisseur.nom : 'Inconnu';
  }

  afficherDetails(commande: CommandeAchat): void {
    this.commandeSelectionnee = commande;
  }
  fermerDetails(): void {
    this.commandeSelectionnee = null;
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