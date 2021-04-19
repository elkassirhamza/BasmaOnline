package com.example.produit.controller;


import com.example.produit.entities.Produit;
import com.example.produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @PostMapping("/produits")
    private Long saveproduit(@RequestBody Produit produits) {
        produitService.saveProduit(produits);
        return produits.getIdProduit();
    }

    @GetMapping("/produit/{idProduit}")
    private Produit getproduit(@PathVariable("idProduit") Long idProduit) {
        return produitService.getProduitById(idProduit);
    }

    @DeleteMapping("/produits/{idProduit}")
    private void deleteproduit(@PathVariable("idProduit") Long idProduit) {
        produitService.delete(idProduit);
    }

    @GetMapping("/allProduits")
    private List<Produit> getAllproduit() {
        return produitService.getAllProduit();
    }




    @PutMapping("/updateProduit/{idProduit}")
    private Produit update(@PathVariable("idProduit") Long id, @RequestBody Produit produit) {
        produitService.update(produit, id);
        return produit;
    }

}
