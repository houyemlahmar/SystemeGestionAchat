package com.gestionAchat.controller;

import com.gestionAchat.dto.LigneCommandeAchatDTO;
import com.gestionAchat.service.LigneCommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/lignes")
public class LigneCommandeAchatController {
    
    @Autowired
    private LigneCommandeAchatService service;

    @GetMapping
    public List<LigneCommandeAchatDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public LigneCommandeAchatDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public LigneCommandeAchatDTO save(@RequestBody LigneCommandeAchatDTO ligneDTO) {
        return service.save(ligneDTO);
    }
    
    @PutMapping("/{id}")
    public LigneCommandeAchatDTO update(@PathVariable Long id, @RequestBody LigneCommandeAchatDTO ligneDTO) {
        return service.update(id, ligneDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
