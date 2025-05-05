package com.gestionAchat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.dto.CommandeAchatDTO;
import com.gestionAchat.models.CommandeAchat;
import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.repository.CommandeAchatRepository;

@Service
public class CommandeAchatService {

    @Autowired private CommandeAchatRepository repository;
    @Autowired private ModelMapper modelMapper;

    public List<CommandeAchatDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CommandeAchatDTO getById(Long id) {
        CommandeAchat c = repository.findById(id).orElse(null);
        return toDTO(c);
    }

    public CommandeAchatDTO save(CommandeAchatDTO dto) {
        CommandeAchat entity = fromDTO(dto);
        CommandeAchat saved = repository.save(entity);
        return toDTO(saved);
    }
    
    public CommandeAchatDTO update(Long id, CommandeAchatDTO dto) {
        CommandeAchat existing = repository.findById(id).orElse(null);
        if (existing != null) {
            CommandeAchat updated = modelMapper.map(dto, CommandeAchat.class);
            updated.setId(id); // préserver l'ID d'origine
            if (dto.getFournisseurId() != null) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(dto.getFournisseurId());
                updated.setFournisseur(fournisseur);
            }
            CommandeAchat saved = repository.save(updated);
            return toDTO(saved);
        }
        return null;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Conversion avec ModelMapper + ajustement fournisseur
    private CommandeAchatDTO toDTO(CommandeAchat c) {
        CommandeAchatDTO dto = modelMapper.map(c, CommandeAchatDTO.class);
        if (c.getFournisseur() != null) {
            dto.setFournisseurId(c.getFournisseur().getId());
        }
        return dto;
    }

    private CommandeAchat fromDTO(CommandeAchatDTO dto) {
        CommandeAchat c = modelMapper.map(dto, CommandeAchat.class);
        if (dto.getFournisseurId() != null) {
            Fournisseur f = new Fournisseur();
            f.setId(dto.getFournisseurId());
            c.setFournisseur(f);
        }
        return c;
    }
}
