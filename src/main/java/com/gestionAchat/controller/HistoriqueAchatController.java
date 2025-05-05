package com.gestionAchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.gestionAchat.dto.HistoriqueAchatDTO;
import com.gestionAchat.models.HistoriqueAchats;
import com.gestionAchat.service.HistoriqueAchatService;

@RestController
@RequestMapping("/api/historiques")
public class HistoriqueAchatController {
    @Autowired private HistoriqueAchatService service;

    @GetMapping
    public List<HistoriqueAchatDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HistoriqueAchatDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HistoriqueAchatDTO save(@RequestBody HistoriqueAchatDTO dto) {
        return service.save(dto);
    }
    
    @PutMapping("/{id}")
    public HistoriqueAchatDTO update(@PathVariable Long id, @RequestBody HistoriqueAchatDTO dto) {
        return service.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
