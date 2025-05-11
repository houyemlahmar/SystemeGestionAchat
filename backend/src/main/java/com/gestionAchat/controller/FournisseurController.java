package com.gestionAchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.gestionAchat.dto.FournisseurDTO;
import com.gestionAchat.service.FournisseurService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService service;

    @GetMapping
    public List<FournisseurDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FournisseurDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public FournisseurDTO save(@RequestBody FournisseurDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public FournisseurDTO update(@PathVariable Long id, @RequestBody FournisseurDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}