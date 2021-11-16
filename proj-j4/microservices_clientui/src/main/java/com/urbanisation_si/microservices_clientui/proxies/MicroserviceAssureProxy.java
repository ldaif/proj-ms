/**
 * 
 */
package com.urbanisation_si.microservices_clientui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.urbanisation_si.microservices_clientui.beans.AssureBean;

/**
 * @author Patrice
 *
 */
//J4 - 7
@FeignClient(name = "microservice-assure", url = "localhost:9999")
public interface MicroserviceAssureProxy {
	
	@GetMapping(path="/previt/listerLesAssures")
	List<AssureBean> getAllAssures();
	
	@GetMapping(path="/previt/Assure/numeroAssure/{numeroAssure}")
	public List<AssureBean> rechercherAssureNumeroAssure(@PathVariable Long numeroAssure);

	//J4 - 10
	@GetMapping(path="/previt/rechercherAssureNomPrenom/{nom}/{prenom}")
	List<AssureBean> rechercherAssureNomPrenom(@PathVariable String nom, @PathVariable String prenom);
	
}
