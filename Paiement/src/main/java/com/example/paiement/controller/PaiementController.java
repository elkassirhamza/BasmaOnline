package com.example.paiement.controller;


import com.example.paiement.Exceptions.PaiementExistantException;
import com.example.paiement.Exceptions.PaiementImpossibleException;
import com.example.paiement.model.Paiement;
import com.example.paiement.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaiementController {

    @Autowired
    PaiementRepository paiementRepository;

    @PostMapping(value = "/paiement")
    public ResponseEntity<Paiement> payerUneCommande(@RequestBody Paiement paiement){

        //Vérifions s'il y a déjà un paiement enregistré pour cette commande

        Paiement paiementExistant = paiementRepository.findByidCommande(paiement.getIdCommande());
        if(paiementExistant != null) throw new PaiementExistantException("Cette commande est déjà payée");


        //Enregistrer le paiement
        Paiement newPaiement = paiementRepository.save(paiement);


        if(newPaiement == null) throw new PaiementImpossibleException("Erreur, impossible d'établir le paiement, réessayez plus tard");

        /*TODO Nous allons appeler le Microservice Commandes ici pour lui signifier que le paiement est accepté*/

        return new ResponseEntity<Paiement>(newPaiement, HttpStatus.CREATED);
    }
}
