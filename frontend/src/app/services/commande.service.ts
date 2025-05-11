import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CommandeAchat } from '../models/CommandeAchat.model';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {
private apiUrl = 'http://localhost:9090/api/commandes';

  constructor(private http: HttpClient) {}

  getAll(): Observable<CommandeAchat[]> {
    return this.http.get<CommandeAchat[]>(this.apiUrl);
  }

  getById(id: number): Observable<CommandeAchat> {
    return this.http.get<CommandeAchat>(`${this.apiUrl}/${id}`);
  }

  save(commande: CommandeAchat) {
  // Si la date est un objet Date, la convertir
  const formattedDate = commande.date instanceof Date 
    ? commande.date.toISOString().substring(0, 10) 
    : commande.date;

  const payload = {
    ...commande,
    date: formattedDate
  };

  return this.http.post<CommandeAchat>(`${this.apiUrl}`, payload);
}


  update(id: number, commande: CommandeAchat): Observable<CommandeAchat> {
    const commandeToSend = {
      ...commande,
      date: commande.date.toISOString().split('T')[0], // Conversion en yyyy-MM-dd
    };
    return this.http.put<CommandeAchat>(`${this.apiUrl}/${id}`, commandeToSend);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
