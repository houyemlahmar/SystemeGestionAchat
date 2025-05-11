import { Component, OnInit } from '@angular/core';
import { CommandeAchat } from '../../models/CommandeAchat.model';
import { LigneCommandeAchat } from '../../models/LigneCommandeAchat.model';
import { ActivatedRoute, Router } from '@angular/router';
import { CommandeService } from '../../services/commande.service';

@Component({
  selector: 'app-commande-form',
  standalone: false,
  templateUrl: './commande-form.component.html',
  styleUrls: ['./commande-form.component.css']
})
export class CommandeFormComponent implements OnInit {
  commande: CommandeAchat = {
    id: undefined,
    date: new Date(),
    montant: 0,
    lignes: [],
    fournisseurId: undefined,
    statut: 'En cours'
  };
  lignes: LigneCommandeAchat[] = [];
  montantTotal: number = 0;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private commandeService: CommandeService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.commandeService.getById(+id).subscribe((data) => {
        this.commande = data;
        this.lignes = data.lignes || [];
        this.calculateTotal();
      });
    }
  }

  addLigne(): void {
    this.lignes.push({
      id: undefined,
      produit: '',
      quantite: 0,
      prixUnitaire: 0,
      commandeId: this.commande.id || 0
    });
  }

  removeLigne(index: number): void {
    this.lignes.splice(index, 1);
    this.calculateTotal();
  }

  calculateTotal(): void {
    this.montantTotal = this.lignes.reduce((total, ligne) => {
      return total + ligne.quantite * ligne.prixUnitaire;
    }, 0);
    this.commande.montant = this.montantTotal;
  }

saveCommande(): void {
  // Recalculer le montant avant d'envoyer la commande
  this.calculateTotal();

  this.commande.lignes = this.lignes.map(ligne => ({
    id: ligne.id && ligne.id > 0 ? ligne.id : undefined,
    produit: ligne.produit,
    quantite: ligne.quantite,
    prixUnitaire: ligne.prixUnitaire,
    commandeId: this.commande.id || 0
  }));

  // Conversion de la date au format 'YYYY-MM-DD'
  const formattedDate = this.commande.date instanceof Date 
    ? this.commande.date.toISOString().substring(0, 10) 
    : this.commande.date;

  const commandeToSave: CommandeAchat = {
    ...this.commande,
    date: new Date(formattedDate) // Conversion en Date
  };

  console.log("Commande envoyée :", commandeToSave);

  this.commandeService.save(commandeToSave).subscribe({
    next: (savedCommande) => {
      console.log('Commande enregistrée avec succès', savedCommande);

      // Ensure `savedCommande.id` is defined before updating `ligne.commandeId`
      if (savedCommande.id !== undefined) {
        this.lignes.forEach(ligne => {
          ligne.commandeId = savedCommande.id!; // Assert that `id` is not undefined
        });
      } else {
        console.error('Erreur : L\'ID de la commande enregistrée est undefined.');
      }

      console.log('Lignes après mise à jour des IDs :', this.lignes);

      this.router.navigate(['/commandes']);
    },
    error: (err) => {
      console.error('Erreur lors de l\'enregistrement de la commande', err);
    }
  });
}

}