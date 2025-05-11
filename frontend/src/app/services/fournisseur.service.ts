import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Fournisseur } from '../models/Fournisseur.model';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  private apiUrl = 'http://localhost:9090/api/fournisseurs';

  constructor(private http: HttpClient) {}

  getFournisseurs(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(this.apiUrl).pipe(
      catchError(error => this.handleError('Erreur lors de la récupération des fournisseurs', error))
    );
  }

  getFournisseurById(id: number): Observable<Fournisseur> {
    return this.http.get<Fournisseur>(`${this.apiUrl}/${id}`).pipe(
      catchError(error => this.handleError('Erreur lors de la récupération du fournisseur', error))
    );
  }

  addFournisseur(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.http.post<Fournisseur>(this.apiUrl, fournisseur).pipe(
      catchError(error => this.handleError("Erreur lors de l'ajout du fournisseur", error))
    );
  }

  updateFournisseur(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.http.put<Fournisseur>(`${this.apiUrl}/${fournisseur.id}`, fournisseur).pipe(
      catchError(error => this.handleError('Erreur lors de la mise à jour du fournisseur', error))
    );
  }

  deleteFournisseur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      catchError(error => this.handleError('Erreur lors de la suppression du fournisseur', error))
    );
  }

  private handleError(message: string, error: any): Observable<never> {
  console.error(message, error);
  alert(message + ': ' + error.message);
  return throwError(() => new Error(message));
}

}
