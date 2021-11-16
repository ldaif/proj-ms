/**
 * 
 */
package com.urbanisation_si.microservices_clientui.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.urbanisation_si.microservices_clientui.beans.ProduitBean;

/**
 * @author Patrice
 *
 */
@FeignClient(name = "microservice-produit"
, url = "localhost:9998", decode404 = true
)
public interface MicroserviceProduitProxy {
	
	@GetMapping(path="/produit/rechercherNumeroProduit/{numeroProduit}")
	public ProduitBean rechercherProduitNumeroProduit(@PathVariable Long numeroProduit);
	
	@GetMapping(path="/produit/listerLesProduits")
	public List<ProduitBean> listerLesProduits();
	
}
