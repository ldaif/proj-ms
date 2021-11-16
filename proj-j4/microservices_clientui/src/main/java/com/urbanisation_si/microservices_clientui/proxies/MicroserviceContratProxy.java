/**
 * 
 */
package com.urbanisation_si.microservices_clientui.proxies;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.urbanisation_si.microservices_clientui.beans.ContratBean;

/**
 * @author Patrice
 *
 */
@FeignClient(name = "microservice-contrat"
, url = "localhost:9997", decode404 = true
)
public interface MicroserviceContratProxy {
	
	@GetMapping(path="/contrat/rechercherNumeroAssure/{numeroAssure}")
	public List<ContratBean> rechercherContratNumeroAssure(@PathVariable Long numeroAssure);
	
    @PostMapping (path="/contrat/creerContrat")
    public ContratBean creerContrat(@RequestBody ContratBean contrat);
	
	@PostMapping(path="/contrat/creer")
	public ContratBean creer(@RequestBody Long numeroAssure);
	
	@GetMapping(path="/contrat/affecterNumeroProduit/{numeroAssure}/{numeroProduit}")
	public ContratBean affecterNumeroProduit(@PathVariable Long numeroAssure, @PathVariable Long numeroProduit);
	
	@GetMapping(path="/contrat/finaliserContrat/{numeroAssure}/{numeroContrat}/{dateDebut}")
	public ContratBean finaliserContrat(@PathVariable Long numeroAssure, @PathVariable Long numeroContrat, @PathVariable  String dateDebut);
//			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut);
}
