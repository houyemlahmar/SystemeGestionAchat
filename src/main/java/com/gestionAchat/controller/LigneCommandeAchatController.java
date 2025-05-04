package com.gestionAchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionAchat.models.LigneCommandeAchat;
import com.gestionAchat.service.LigneCommandeAchatService;

@RestController
@RequestMapping("/api/lignes")
public class LigneCommandeAchatController {
    @Autowired private LigneCommandeAchatService service;
    @GetMapping public List<LigneCommandeAchat> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public LigneCommandeAchat getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public LigneCommandeAchat save(@RequestBody LigneCommandeAchat l) { return service.save(l); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}