import { LigneCommandeAchat } from "./LigneCommandeAchat.model";

export interface CommandeAchat {
  id?: number;
  fournisseurId?: number;
  date: Date;
  statut: string;
  montant: number;
  lignes?: LigneCommandeAchat[];
}