import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FournisseurService } from '../../services/fournisseur.service';
import { Fournisseur } from '../../models/Fournisseur.model';

@Component({
  selector: 'app-fournisseur-form',
  standalone: false,
  templateUrl: './fournisseur-form.component.html',
  styleUrls: ['./fournisseur-form.component.css']
})
export class FournisseurFormComponent implements OnInit {
  fournisseur: Fournisseur = {
    id: 0,
    nom: '',
    numero: 0,
    email: '',
    adresse: '',
    qualiteService: '',
    note: 0
  };

  errorMessage: { numero?: string; email?: string; note?: string } = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fournisseurService: FournisseurService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const id = idParam ? +idParam : null;

    if (id !== null) {
      this.fournisseurService.getFournisseurById(id).subscribe(
        (data) => {
          this.fournisseur = data;
        },
        (error) => {
          console.error('Erreur lors de la récupération du fournisseur:', error);
          alert('Erreur lors de la récupération du fournisseur');
        }
      );
    }
  }

  addOrUpdateFournisseur() {
    this.validateForm();

    if (Object.keys(this.errorMessage).length > 0) {
      console.log('Form contains errors:', this.errorMessage);
      return;
    }

    if (this.fournisseur.id) {
      this.fournisseurService.updateFournisseur(this.fournisseur).subscribe(() => {
        alert('Fournisseur mis à jour avec succès');
        this.router.navigate(['/fournisseurs']);
      });
    } else {
      this.fournisseurService.addFournisseur(this.fournisseur).subscribe(() => {
        alert('Fournisseur ajouté avec succès');
        this.router.navigate(['/fournisseurs']);
      });
    }
  }

  validateForm() {
    this.errorMessage = {};

    if (!this.fournisseur.numero || this.fournisseur.numero <= 0) {
      this.errorMessage.numero = "Le numéro est requis et doit être supérieur à 0";
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (this.fournisseur.email && !emailPattern.test(this.fournisseur.email)) {
      this.errorMessage.email = "Format d'email invalide";
    }

    if (this.fournisseur.note !== null && (this.fournisseur.note < 0 || this.fournisseur.note > 5)) {
      this.errorMessage.note = "La note doit être entre 0 et 5";
    }
  }
}
