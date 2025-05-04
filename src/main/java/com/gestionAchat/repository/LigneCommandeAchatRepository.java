package com.gestionAchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionAchat.models.LigneCommandeAchat;

public interface LigneCommandeAchatRepository extends JpaRepository<LigneCommandeAchat, Long> {
}
