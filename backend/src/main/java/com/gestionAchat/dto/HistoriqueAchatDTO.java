package com.gestionAchat.dto;

import lombok.Data;

@Data
public class HistoriqueAchatDTO {
	private Long id;
    private Long fournisseurId;
    private Long commandeId;
    private String statut;
    private Long delaiLivraison;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Long fournisseurId) { this.fournisseurId = fournisseurId; }

    public Long getCommandeId() { return commandeId; }
    public void setCommandeId(Long commandeId) { this.commandeId = commandeId; }

    public String getstatut() { return statut; }
    public void setstatut(String statut) { this.statut = statut; }

    public Long getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(Long delaiLivraison) { this.delaiLivraison = delaiLivraison; }
}
