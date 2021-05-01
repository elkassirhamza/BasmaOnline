package com.example.categories.controller;


import com.example.categories.entity.Category;
import com.example.categories.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;


    Category category;

    @RequestMapping(value= "/add",method = RequestMethod.POST)
    public String newProduct(@RequestBody Produit produit){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Produit> entity = new HttpEntity<>(produit,headers);

    return restTemplate.exchange("http://localhost:8088/produits", HttpMethod.POST,entity,String.class).getBody();
    }


    @RequestMapping(value = "/allProducts")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8088/allProduits/", HttpMethod.GET, entity, String.class).getBody();
    }

    /*@GetMapping("/allProducts")
    public Produit getAllProduct(){
        Produit produit = restTemplate.getForObject("http://localhost:8088/allProduits/",Produit.class);
        return produit;
    }*/

    @GetMapping("/{id}")
    public Produit getproduit(@PathVariable("id") Long idProduit){
        Produit produit =restTemplate.getForObject("http://localhost:8088/produit/"+idProduit, Produit.class);
        return produit;
    }

    @DeleteMapping("/delete/{idProduit}")
    private void deleteproduit(@PathVariable("idProduit") Long idProduit) {
       restTemplate.delete("http://localhost:8088/produits/"+idProduit,Produit.class);
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable("id") Long idProduit,@RequestBody Produit produit){
       restTemplate.put("http://localhost:8088/updateProduit/"+idProduit, produit, Produit.class);
       return produit;
    }


}
