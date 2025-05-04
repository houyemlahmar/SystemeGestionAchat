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

import com.gestionAchat.models.CommandeAchat;
import com.gestionAchat.service.CommandeAchatService;


@RestController
@RequestMapping("/api/commandes")
public class CommandeAchatController {
    @Autowired private CommandeAchatService service;
    @GetMapping public List<CommandeAchat> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public CommandeAchat getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public CommandeAchat save(@RequestBody CommandeAchat c) { return service.save(c); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}