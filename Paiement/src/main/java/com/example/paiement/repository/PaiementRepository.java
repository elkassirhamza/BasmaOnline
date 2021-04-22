package com.example.paiement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.paiement.model.Paiement;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer>{

    Paiement findByidCommande(int idCommande);
}
