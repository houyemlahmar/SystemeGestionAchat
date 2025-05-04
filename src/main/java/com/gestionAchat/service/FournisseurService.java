package com.gestionAchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.repository.FournisseurRepository;


/**
 * FournisseurService is a service class that provides methods to manage Fournisseur entities.
 * It uses the FournisseurRepository to perform CRUD operations on the database.
 */

@Service
public class FournisseurService {
    @Autowired private FournisseurRepository repository;
    public List<Fournisseur> getAll() { return repository.findAll(); }
    public Fournisseur getById(Long id) { return repository.findById(id).orElse(null); }
    public Fournisseur save(Fournisseur f) { return repository.save(f); }
    public void delete(Long id) { repository.deleteById(id); }
}