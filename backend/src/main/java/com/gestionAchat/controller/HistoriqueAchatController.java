package com.gestionAchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.gestionAchat.dto.HistoriqueAchatDTO;
import com.gestionAchat.service.HistoriqueAchatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/historiques")
public class HistoriqueAchatController {
    @Autowired private HistoriqueAchatService service;

    @PostMapping
    public ResponseEntity<HistoriqueAchatDTO> createHistorique(@RequestBody HistoriqueAchatDTO historiqueAchatDTO) {
        // Logique de création
        HistoriqueAchatDTO createdHistorique = service.createHistorique(historiqueAchatDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistorique);
    }
    
    @GetMapping
    public List<HistoriqueAchatDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HistoriqueAchatDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
