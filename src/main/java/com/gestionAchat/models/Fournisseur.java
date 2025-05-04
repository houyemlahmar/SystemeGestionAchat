package com.gestionAchat.models;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Fournisseur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String contact;
    private String qualiteService;
    private Double note;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.PERSIST)
    private List<CommandeAchat> commandes = new ArrayList<>();

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.PERSIST)
    private List<HistoriqueAchats> historiques = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getQualiteService() { return qualiteService; }
    public void setQualiteService(String qualiteService) { this.qualiteService = qualiteService; }
    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }
    public List<CommandeAchat> getCommandes() { return commandes; }
    public void setCommandes(List<CommandeAchat> commandes) { this.commandes = commandes; }
    public List<HistoriqueAchats> getHistoriques() { return historiques; }
    public void setHistoriques(List<HistoriqueAchats> historiques) { this.historiques = historiques; }
}