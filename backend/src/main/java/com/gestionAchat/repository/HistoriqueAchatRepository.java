package com.gestionAchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionAchat.models.HistoriqueAchats;

public interface HistoriqueAchatRepository extends JpaRepository<HistoriqueAchats, Long> {
}
