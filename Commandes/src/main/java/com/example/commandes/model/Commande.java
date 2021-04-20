package com.example.commandes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Long idproduct;
    private Date dateCommand;
    private int quantite;
    private String adress;
    private Boolean commandePayee;

    public Commande() {
    }

    public Commande(Date dateCommand, int quantite,String adress, Boolean commandePayee) {
        this.dateCommand = dateCommand;
        this.quantite = quantite;
        this.adress= adress;
        this.commandePayee = commandePayee;
    }

    public Commande(int id, Long idproduct, Date dateCommand, int quantite,String adress, Boolean commandePayee) {
        this.id = id;
        this.idproduct = idproduct;
        this.dateCommand = dateCommand;
        this.quantite = quantite;
        this.adress= adress;
        this.commandePayee = commandePayee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public Date getDateCommand() {
        return dateCommand;
    }

    public void setDateCommand(Date dateCommand) {
        this.dateCommand = dateCommand;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getCommandePayee() {
        return commandePayee;
    }

    public void setCommandePayee(Boolean commandePayee) {
        this.commandePayee = commandePayee;
    }
}
