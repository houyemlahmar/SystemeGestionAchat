package com.gestionAchat.dto;



import lombok.Data;

/**
 * DTO (Data Transfer Object) pour la classe Fournisseur.
 * Utilisé pour transférer les données entre le client et le serveur.
 */

@Data
public class FournisseurDTO {
    private Long id;
    private String nom;
    private String contact;
    private String qualiteService;
    private double note;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getQualiteService() { return qualiteService; }
    public void setQualiteService(String qualiteService) { this.qualiteService = qualiteService; }

    public double getNote() { return note; }
    public void setNote(double note) { this.note = note; }
}