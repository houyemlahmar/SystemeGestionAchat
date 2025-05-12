export interface HistoriqueAchat {
  id?: number;
  fournisseurId: number;
  produit: string;
  quantite: number;
  delaiLivraison: number;
  date: string; // Date de l'achat
  montant: number; // Montant total de l'achat
}