package com.example.produit.services;

import com.example.produit.entities.Produit;
import com.example.produit.repositories.Produitrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
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
        produit.setIdProduit(idProduit);
        produitRepository.save(produit);
    }

           public List<Produit> getProduit(String recherche) {
               // TODO Auto-generated method stub
               List<Produit> produit = produitRepository.findByNameLike("%" + recherche + "%");
               if (produit == null)
                   System.out.println("Product Not Found!");
               return produit;

           }
}
