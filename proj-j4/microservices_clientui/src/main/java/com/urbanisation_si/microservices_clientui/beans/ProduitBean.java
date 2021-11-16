/**
 * 
 */
package com.urbanisation_si.microservices_clientui.beans;

import java.util.Collection;

import javax.validation.constraints.NotNull;

/**
 * @author Patrice
 *
 */
public class ProduitBean {
	
    @NotNull
	private Long numeroProduit;
    
    @NotNull
	private String libelle;

	public Long getNumeroProduit() {
		return numeroProduit;
	}

	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    

}
