package com.gestionAchat.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class CommandeAchatDTO {
    private Long id;
    private Long fournisseurId;
    private LocalDate date;
    private String statut;
    private Double montant;
    private List<LigneCommandeAchatDTO> lignes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Long fournisseurId) { this.fournisseurId = fournisseurId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public List<LigneCommandeAchatDTO> getLignes() { return lignes; }
    public void setLignes(List<LigneCommandeAchatDTO> lignes) { this.lignes = lignes; }
}