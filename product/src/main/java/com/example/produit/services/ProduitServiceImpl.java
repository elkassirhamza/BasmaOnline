package com.example.produit.services;

import com.example.produit.entities.Produit;
import com.example.produit.repositories.Produitrepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProduitServiceImpl /*implements ProduitService*/{

    /*@Autowired
    Produitrepository produitRepository;

    public void saveProduit(Produit produit)
    {
        produitRepository.save(produit);
    }

    public Produit getProduitById(Long idProduit)
    {
        return produitRepository.findByIdProduit(idProduit);
    }

    public void delete(Long idProduit)
    {
        produitRepository.deleteById(idProduit);
    }

    public List<Produit> getAllProduit()
    {
        List<Produit> produit = new ArrayList<>();
        produitRepository.findAll().forEach(prdt -> produit.add(prdt));
        return produit;
    }

    public void update(Produit produit, Long idProduit)
    {
        produitRepository.save(produit);
    }*/
}
