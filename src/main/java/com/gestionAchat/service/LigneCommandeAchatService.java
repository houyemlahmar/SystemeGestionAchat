package com.gestionAchat.service;

import com.gestionAchat.dto.LigneCommandeAchatDTO;
import com.gestionAchat.models.CommandeAchat;
import com.gestionAchat.models.LigneCommandeAchat;
import com.gestionAchat.repository.CommandeAchatRepository;
import com.gestionAchat.repository.LigneCommandeAchatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigneCommandeAchatService {

    @Autowired
    private LigneCommandeAchatRepository repository;

    @Autowired
    private CommandeAchatRepository commandeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LigneCommandeAchatDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LigneCommandeAchatDTO getById(Long id) {
        LigneCommandeAchat ligne = repository.findById(id).orElse(null);
        return (ligne != null) ? toDTO(ligne) : null;
    }

    public LigneCommandeAchatDTO save(LigneCommandeAchatDTO dto) {
        LigneCommandeAchat entity = fromDTO(dto);
        LigneCommandeAchat saved = repository.save(entity);
        return toDTO(saved);
    }
    
    public LigneCommandeAchatDTO update(Long id, LigneCommandeAchatDTO dto) {
        LigneCommandeAchat existing = repository.findById(id).orElse(null);
        if (existing != null) {
            LigneCommandeAchat updatedEntity = fromDTO(dto);
            updatedEntity.setId(id); // Assure qu’on met à jour l'entité existante
            LigneCommandeAchat saved = repository.save(updatedEntity);
            return toDTO(saved);
        }
        return null;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Conversion avec ModelMapper + ajustement commande
    private LigneCommandeAchatDTO toDTO(LigneCommandeAchat entity) {
        LigneCommandeAchatDTO dto = modelMapper.map(entity, LigneCommandeAchatDTO.class);
        if (entity.getCommande() != null) {
            dto.setCommandeId(entity.getCommande().getId());
        }
        return dto;
    }

    private LigneCommandeAchat fromDTO(LigneCommandeAchatDTO dto) {
        LigneCommandeAchat entity = modelMapper.map(dto, LigneCommandeAchat.class);
        if (dto.getCommandeId() != null) {
            CommandeAchat commande = new CommandeAchat();
            commande.setId(dto.getCommandeId());
            entity.setCommande(commande);
        }
        return entity;
    }
}
