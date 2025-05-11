import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fournisseur } from '../../models/Fournisseur.model';
import { FournisseurService } from '../../services/fournisseur.service';

@Component({
  selector: 'app-fournisseur-list',
  standalone: false,
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css']
})
export class FournisseurListComponent implements OnInit {
  fournisseurs: Fournisseur[] = [];

  constructor(private fournisseurService: FournisseurService, private router: Router) {}

  ngOnInit(): void {
    this.loadFournisseurs();
  }

  loadFournisseurs() {
    this.fournisseurService.getFournisseurs().subscribe(data => {
      this.fournisseurs = data;
    });
  }

  addFournisseur() {
    this.router.navigate(['/fournisseur/add']);
  }

  editFournisseur(fournisseur: Fournisseur) {
    this.router.navigate(['/fournisseur/edit', fournisseur.id]);
  }

  deleteFournisseur(id: number) {
    this.fournisseurService.deleteFournisseur(id).subscribe(() => this.loadFournisseurs());
  }
}
