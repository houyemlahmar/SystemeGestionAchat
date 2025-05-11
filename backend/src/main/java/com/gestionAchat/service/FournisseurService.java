package com.gestionAchat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionAchat.dto.FournisseurDTO;
import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.repository.FournisseurRepository;

@Service
@Transactional
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
        return fournisseur != null ? modelMapper.map(fournisseur, FournisseurDTO.class) : null;
    }

    public FournisseurDTO save(FournisseurDTO dto) {
        if (dto == null) return null;

        Fournisseur fournisseur = modelMapper.map(dto, Fournisseur.class);
        fournisseur.setId(null); // Empêche la mise à jour si l'ID est présent

        Fournisseur saved = repository.save(fournisseur);
        return modelMapper.map(saved, FournisseurDTO.class);
    }

    public FournisseurDTO update(Long id, FournisseurDTO dto) {
        Fournisseur existing = repository.findById(id).orElse(null);
        if (existing != null) {
            modelMapper.map(dto, existing);
            Fournisseur saved = repository.save(existing);
            return modelMapper.map(saved, FournisseurDTO.class);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}