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

import com.gestionAchat.models.HistoriqueAchats;
import com.gestionAchat.service.HistoriqueAchatService;

@RestController
@RequestMapping("/api/historiques")
public class HistoriqueAchatController {
    @Autowired private HistoriqueAchatService service;
    @GetMapping public List<HistoriqueAchats> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public HistoriqueAchats getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping public HistoriqueAchats save(@RequestBody HistoriqueAchats h) { return service.save(h); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}
 