package com.example.commandes.services;

import com.example.commandes.model.Commande;
import com.example.commandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    public void update(Commande commande, int id)
    {
        commande.setId(id);
        commandeRepository.save(commande);
    }

}
