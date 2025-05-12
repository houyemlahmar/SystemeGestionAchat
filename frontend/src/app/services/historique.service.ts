import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HistoriqueAchat } from '../models/HistoriqueAchat.model';

@Injectable({
  providedIn: 'root'
})
export class HistoriqueService {
  private apiUrl = 'http://localhost:9090/api/historiques';

  constructor(private http: HttpClient) {}

  saveHistorique(historique: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, historique, {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
}

  getHistorique(): Observable<HistoriqueAchat[]> {
    return this.http.get<HistoriqueAchat[]>(this.apiUrl);
  }
}