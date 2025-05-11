import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LigneCommandeAchat } from '../models/LigneCommandeAchat.model';

@Injectable({
  providedIn: 'root'
})
export class LigneService {
private apiUrl = 'http://localhost:9090/api/lignes';

  constructor(private http: HttpClient) {}

  getAll(): Observable<LigneCommandeAchat[]> {
    return this.http.get<LigneCommandeAchat[]>(this.apiUrl);
  }

  getById(id: number): Observable<LigneCommandeAchat> {
    return this.http.get<LigneCommandeAchat>(`${this.apiUrl}/${id}`);
  }

  save(dto: LigneCommandeAchat): Observable<LigneCommandeAchat> {
    return this.http.post<LigneCommandeAchat>(this.apiUrl, dto);
  }

  update(id: number, dto: LigneCommandeAchat): Observable<LigneCommandeAchat> {
    return this.http.put<LigneCommandeAchat>(`${this.apiUrl}/${id}`, dto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}