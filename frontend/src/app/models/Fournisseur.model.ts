import { CommandeAchat } from "./CommandeAchat.model";
import { HistoriqueAchat } from "./HistoriqueAchat.model";

export interface Fournisseur {
  id?: number;
  nom: string;
  numero: number;
  email: string;
  adresse: string;  
  qualiteService: string;
  note: number;
  commandes?: CommandeAchat[];
  historiques?: HistoriqueAchat[];
}