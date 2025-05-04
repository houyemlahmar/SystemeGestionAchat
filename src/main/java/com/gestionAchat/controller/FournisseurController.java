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

import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.service.FournisseurService;


@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
    @Autowired private FournisseurService service;
    @GetMapping public List<Fournisseur> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public Fournisseur getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public Fournisseur save(@RequestBody Fournisseur f) { return service.save(f); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}