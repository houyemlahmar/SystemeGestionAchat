package com.gestionAchat.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class CommandeAchat {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Fournisseur fournisseur;
    private LocalDate date;
    private String statut;
    private Double montant;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.PERSIST)
    private List<LigneCommandeAchat> lignes = new ArrayList<>();

    @OneToMany(mappedBy = "commande", cascade = CascadeType.PERSIST)
    private List<HistoriqueAchats> historiques = new ArrayList<>();

    public void calculateMontant() {
        this.montant = lignes.stream()
                .mapToDouble(ligne -> ligne.getPrixUnitaire() * ligne.getQuantite())
                .sum();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Fournisseur getFournisseur() { return fournisseur; }
    public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public List<LigneCommandeAchat> getLignes() { return lignes; }
    public void setLignes(List<LigneCommandeAchat> lignes) { this.lignes = lignes; }
    public List<HistoriqueAchats> getHistoriques() { return historiques; }
    public void setHistoriques(List<HistoriqueAchats> historiques) { this.historiques = historiques; }
}
