package com.gestionAchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.models.HistoriqueAchats;
import com.gestionAchat.repository.HistoriqueAchatRepository;

@Service
public class HistoriqueAchatService {
    @Autowired private HistoriqueAchatRepository repository;
    public List<HistoriqueAchats> getAll() { return repository.findAll(); }
    public HistoriqueAchats getById(Long id) { return repository.findById(id).orElse(null); }
    public HistoriqueAchats save(HistoriqueAchats h) { return repository.save(h); }
    public void delete(Long id) { repository.deleteById(id); }

}