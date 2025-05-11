package com.gestionAchat.dto;

import lombok.Data;

@Data
public class HistoriqueAchatDTO {
    private Long id;
    private Long fournisseurId;
    private Long commandeId; 

    private long delaiLivraison;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFournisseurId() { return fournisseurId; }
    public void setFournisseurId(Long fournisseurId) { this.fournisseurId = fournisseurId; }

    public Long getCommandeId() { return commandeId; }
    public void setCommandeId(Long commandeId) { this.commandeId = commandeId; }

    public long getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(long delaiLivraison) { this.delaiLivraison = delaiLivraison; }
}
