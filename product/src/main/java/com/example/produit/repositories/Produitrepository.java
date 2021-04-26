package com.example.produit.repositories;

import com.example.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Produitrepository extends JpaRepository<Produit,Long> {

    Produit findByIdProduit(Long idProduit);

    List<Produit> findByNameLike(String recherche);


}
