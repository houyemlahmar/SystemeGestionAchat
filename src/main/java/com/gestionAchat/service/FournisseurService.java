package com.gestionAchat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.dto.FournisseurDTO;
import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.repository.FournisseurRepository;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<FournisseurDTO> getAll() {
        return repository.findAll().stream()
            .map(f -> modelMapper.map(f, FournisseurDTO.class))
            .collect(Collectors.toList());
    }

    public FournisseurDTO getById(Long id) {
        Fournisseur fournisseur = repository.findById(id).orElse(null);
        return modelMapper.map(fournisseur, FournisseurDTO.class);
    }

    public FournisseurDTO save(FournisseurDTO dto) {
        Fournisseur fournisseur = modelMapper.map(dto, Fournisseur.class);
        Fournisseur saved = repository.save(fournisseur);
        return modelMapper.map(saved, FournisseurDTO.class);
    }
    
    public FournisseurDTO update(Long id, FournisseurDTO dto) {
        Fournisseur existing = repository.findById(id).orElse(null);
        if (existing != null) {
            Fournisseur updated = modelMapper.map(dto, Fournisseur.class);
            updated.setId(id); // préserver l'ID d'origine
            Fournisseur saved = repository.save(updated);
            return modelMapper.map(saved, FournisseurDTO.class);
        }
        return null;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
