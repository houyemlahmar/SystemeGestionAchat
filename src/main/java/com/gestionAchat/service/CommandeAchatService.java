package com.gestionAchat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionAchat.dto.CommandeAchatDTO;
import com.gestionAchat.dto.LigneCommandeAchatDTO;
import com.gestionAchat.models.CommandeAchat;
import com.gestionAchat.models.Fournisseur;
import com.gestionAchat.models.LigneCommandeAchat;
import com.gestionAchat.repository.CommandeAchatRepository;
import com.gestionAchat.repository.LigneCommandeAchatRepository;

import jakarta.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class CommandeAchatService {

    @Autowired private CommandeAchatRepository repository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private LigneCommandeAchatRepository ligneRepo;

    private static final Logger logger = LoggerFactory.getLogger(CommandeAchatService.class);

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
	    logger.info("Saving CommandeAchat: {}", dto);
	
	    CommandeAchat entity = fromDTO(dto);
	
	 // Sauvegarder la commande pour obtenir l'ID
	    CommandeAchat savedCommande = repository.save(entity);
	    
	 // Gérer les lignes de commande
	    List<LigneCommandeAchat> lignes = dto.getLignes().stream()
	            .map(ligneDTO -> {
	                LigneCommandeAchat ligne = createOrUpdateLigneCommande(ligneDTO);
	                ligne.setCommande(savedCommande);  // Associer la ligne à la commande
	                return ligneRepo.save(ligne); // Sauvegarder la ligne
	            })
	            .collect(Collectors.toList());

	    savedCommande.setLignes(lignes);
	
	    // Calculer le montant avant la sauvegarde
	    entity.calculateMontant();
	
	    CommandeAchat saved = repository.save(entity);
	    return toDTO(savedCommande);	
	    }

		
	public CommandeAchatDTO update(Long id, CommandeAchatDTO dto) {
	    CommandeAchat existing = repository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Commande avec ID " + id + " non trouvée"));
	
	    existing.setDate(dto.getDate());
	    existing.setStatut(dto.getStatut());
	
	    // Gérer les lignes de commande
	    List<LigneCommandeAchat> lignes = dto.getLignes().stream()
	            .map(this::createOrUpdateLigneCommande)
	            .collect(Collectors.toList());
	
	    existing.setLignes(lignes);
	
	    // Recalculer le montant
	    existing.calculateMontant();
	
	    CommandeAchat updated = repository.save(existing);
	    return toDTO(updated);
	}

	private LigneCommandeAchat createOrUpdateLigneCommande(LigneCommandeAchatDTO dto) {
	    logger.info("Processing LigneCommandeAchatDTO: {}", dto);
	
	    LigneCommandeAchat ligne = (dto.getId() != null && dto.getId() > 0)
	            ? ligneRepo.findById(dto.getId()).orElse(new LigneCommandeAchat())
	            : new LigneCommandeAchat();
	
	    ligne.setProduit(dto.getProduit());
	    ligne.setQuantite(dto.getQuantite());
	    ligne.setPrixUnitaire(dto.getPrixUnitaire());
	
	    return ligne;
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

        if (dto.getLignes() != null) {
            List<LigneCommandeAchat> lignes = dto.getLignes().stream()
                    .map(this::createOrUpdateLigneCommande)
                    .collect(Collectors.toList());
            c.setLignes(lignes);
        }

        return c;
    }

}
