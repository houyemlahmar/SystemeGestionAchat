package com.gestionAchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gestionAchat.models.CommandeAchat;

import com.gestionAchat.repository.CommandeAchatRepository;


@Service
public class CommandeAchatService {
    @Autowired private CommandeAchatRepository repository;
    public List<CommandeAchat> getAll() { return repository.findAll(); }
    public CommandeAchat getById(Long id) { return repository.findById(id).orElse(null); }
    public CommandeAchat save(CommandeAchat c) { return repository.save(c); }
    public void delete(Long id) { repository.deleteById(id); }
}
