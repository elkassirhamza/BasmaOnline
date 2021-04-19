package com.example.produit.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="produits")
public class Produit implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String name;
    private String description;
    private double prix;
    private double prix_achat;

    private String image;
    private int qantite;


    public Produit() {
    }

    public Produit(String name, String description, double prix, String image, int qantite) {
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.qantite = qantite;
    }

    public Produit(String name, String description, double prix, double prix_achat, String image, int qantite) {
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.prix_achat = prix_achat;
        this.image = image;
        this.qantite = qantite;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQantite() {
        return qantite;
    }

    public void setQantite(int qantite) {
        this.qantite = qantite;
    }
}
