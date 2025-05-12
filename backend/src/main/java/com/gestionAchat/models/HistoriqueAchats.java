package com.gestionAchat.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class HistoriqueAchats {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Fournisseur fournisseur;
    @ManyToOne
    private CommandeAchat commande;
    
    private String statut;

    private Long delaiLivraison;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
   
    public Fournisseur getFournisseur() { return fournisseur; }
    public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }
   
    public CommandeAchat getCommandeAchat() { return commande; }
    public void setCommandeAchat(CommandeAchat commande) { this.commande = commande; }
    
    public String getstatut() { return statut; }
    public void setstatut(String statut) { this.statut = statut; }
   
    public Long getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(Long l) { this.delaiLivraison = l; }
}

