package com.gestionAchat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionAchat.dto.HistoriqueAchatDTO;
import com.gestionAchat.models.CommandeAchat;
import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.models.HistoriqueAchats;
import com.gestionAchat.repository.CommandeAchatRepository;
import com.gestionAchat.repository.HistoriqueAchatRepository;

@Service
public class HistoriqueAchatService {

    @Autowired private HistoriqueAchatRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private CommandeAchatRepository commandeRepo;


    public List<HistoriqueAchatDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public HistoriqueAchatDTO getById(Long id) {
        return repository.findById(id)
            .map(this::toDTO)
            .orElse(null);
    }



    public void delete(Long id) {
        repository.deleteById(id);
    }

    private HistoriqueAchatDTO toDTO(HistoriqueAchats h) {
        HistoriqueAchatDTO dto = modelMapper.map(h, HistoriqueAchatDTO.class);
        if (h.getFournisseur() != null) {
            dto.setFournisseurId(h.getFournisseur().getId());
        }
        return dto;
    }

    private HistoriqueAchats fromDTO(HistoriqueAchatDTO dto) {
        HistoriqueAchats h = modelMapper.map(dto, HistoriqueAchats.class);

        if (dto.getFournisseurId() != null) {
            Fournisseur f = new Fournisseur();
            f.setId(dto.getFournisseurId());
            h.setFournisseur(f);
        }

        if (dto.getCommandeId() != null) {
            CommandeAchat commande = commandeRepo.findById(dto.getCommandeId()).orElse(null);
            if (commande != null) {
                h.setCommande(commande);
                h.setDelaiLivraison(
                    java.time.temporal.ChronoUnit.DAYS.between(commande.getDate(), java.time.LocalDate.now())
                );
            }
        }

        return h;
    }

}
