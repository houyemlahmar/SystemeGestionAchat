package com.gestionAchat.dto;

import lombok.Data;

@Data
public class HistoriqueAchatDTO {
    private Long id;
    private Long fournisseurId;
    private String produit;
    private int quantite;
    private int delaiLivraison;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Long fournisseurId) { this.fournisseurId = fournisseurId; }

    public String getProduit() { return produit; }
    public void setProduit(String produit) { this.produit = produit; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public int getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(int delaiLivraison) { this.delaiLivraison = delaiLivraison; }
}
