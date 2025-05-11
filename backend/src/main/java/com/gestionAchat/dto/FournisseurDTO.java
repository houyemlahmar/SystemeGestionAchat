package com.gestionAchat.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO (Data Transfer Object) pour la classe Fournisseur.
 * Utilisé pour transférer les données entre le client et le serveur.
 */

@Data
public class FournisseurDTO {

    private Long id;

    @NotBlank(message = "Nom is required")
    private String nom;

    @NotNull(message = "Numero is required")
    private Long numero;

    @Email(message = "Invalid email format")
    private String email;

    private String adresse;

    private String qualiteService;

    @DecimalMin(value = "0.0", inclusive = true, message = "Note must be at least 0")
    @DecimalMax(value = "5.0", inclusive = true, message = "Note must be at most 5")
    private Double note;
    



    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Long getNumero() { return numero; }
    public void setNumero(Long numero) { this.numero = numero; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getQualiteService() { return qualiteService; }
    public void setQualiteService(String qualiteService) { this.qualiteService = qualiteService; }
    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }
}