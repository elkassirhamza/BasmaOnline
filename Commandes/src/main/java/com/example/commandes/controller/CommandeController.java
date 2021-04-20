package com.example.commandes.controller;


import com.example.commandes.exceptions.CommandeNotFountException;
import com.example.commandes.exceptions.ImpossibleAjouterCommandeException;
import com.example.commandes.model.Commande;
import com.example.commandes.repository.CommandeRepository;
import com.example.commandes.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    CommandeService commandeService;

    @PostMapping(value = "/commandes")
    private ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){

        Commande nouvelleCommande = commandeRepository.save(commande);

        if(nouvelleCommande == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
    }

    @GetMapping(value = "/commandes/{id}")
    private Optional<Commande> recupererUneCommande(@PathVariable int id){
        Optional<Commande> commande = commandeRepository.findById(id);
        if(!commande.isPresent()) throw new CommandeNotFountException("Cette commande n'existe pas");

        return commande;
    }

    @DeleteMapping(value ="/delete/commande/{id}")
    private void deleteCommande(@PathVariable("id") int id){
        commandeRepository.deleteById(id);
    }

    @GetMapping(value = "/allCommande")
    private List<Commande> getAllCommande(){
    return commandeRepository.findAll();
    }

    @PutMapping(value = "/update/{id}")
    private Commande update(@PathVariable("id") int id , @RequestBody Commande commande){
        commandeService.update(commande, id);
        return commande;
    }

}
