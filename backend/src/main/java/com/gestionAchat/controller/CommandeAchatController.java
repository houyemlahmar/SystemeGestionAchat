package com.gestionAchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionAchat.dto.CommandeAchatDTO;
import com.gestionAchat.service.CommandeAchatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/commandes")
public class CommandeAchatController {

    @Autowired private CommandeAchatService service;

    @GetMapping
    public List<CommandeAchatDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CommandeAchatDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CommandeAchatDTO save(@RequestBody CommandeAchatDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public CommandeAchatDTO update(@PathVariable Long id, @RequestBody CommandeAchatDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
