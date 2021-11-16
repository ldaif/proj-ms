package com.urbanisation_si.microservices_contrat_tp_j3.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisation_si.microservices_contrat_tp_j3.modele.Contrat;

public interface ContratRepository extends CrudRepository<Contrat, Integer>  {

	List<Contrat> findByNumeroContrat(Long numeroContrat);
	
	List<Contrat> findByNumeroAssure(Long numeroAssure);
	
	List<Contrat> findByNumeroProduit(Long numeroProduit);

}
