package com.gestionAchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.models.LigneCommandeAchat;
import com.gestionAchat.repository.LigneCommandeAchatRepository;

@Service
public class LigneCommandeAchatService {
    @Autowired private LigneCommandeAchatRepository repository;
    public List<LigneCommandeAchat> getAll() { return repository.findAll(); }
    public LigneCommandeAchat getById(Long id) { return repository.findById(id).orElse(null); }
    public LigneCommandeAchat save(LigneCommandeAchat l) { return repository.save(l); }
    public void delete(Long id) { repository.deleteById(id); }
}

