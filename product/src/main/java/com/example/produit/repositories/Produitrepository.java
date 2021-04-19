package com.example.produit.repositories;

import com.example.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Produitrepository extends JpaRepository<Produit,Long> {

    Produit findByIdProduit(Long idProduit);

}
