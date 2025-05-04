package com.gestionAchat.dto;

import lombok.Data;

@Data
public class LigneCommandeAchatDTO {
    private Long id;
    private Long commandeId;
    private String produit;
    private int quantite;
    private double prixUnitaire;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCommandeId() { return commandeId; }
    public void setCommandeId(Long commandeId) { this.commandeId = commandeId; }

    public String getProduit() { return produit; }
    public void setProduit(String produit) { this.produit = produit; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
}