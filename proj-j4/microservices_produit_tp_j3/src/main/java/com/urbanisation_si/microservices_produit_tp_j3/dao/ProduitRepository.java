package com.urbanisation_si.microservices_produit_tp_j3.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisation_si.microservices_produit_tp_j3.modele.Produit;

public interface ProduitRepository  extends CrudRepository<Produit, Integer>  {

	List<Produit> findByNumeroProduit(Long numeroProduit);
}

