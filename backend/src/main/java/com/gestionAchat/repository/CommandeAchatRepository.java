package com.gestionAchat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionAchat.models.CommandeAchat;

public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, Long> {
}
