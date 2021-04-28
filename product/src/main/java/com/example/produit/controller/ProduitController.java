package com.example.produit.controller;


import com.example.produit.entities.Category;
import com.example.produit.entities.Produit;
import com.example.produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    ProduitService produitService;

    Category category;

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


    @GetMapping(value="/recherche/{recherhce}")
    public ResponseEntity<List<Produit>> findProductByName(@PathVariable String recherhce) {
        List<Produit> product5 = produitService.getProduit(recherhce);
        return new ResponseEntity<List<Produit>>(product5, HttpStatus.OK);
    }
}
