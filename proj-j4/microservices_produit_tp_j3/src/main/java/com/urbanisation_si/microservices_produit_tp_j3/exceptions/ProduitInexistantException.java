package com.urbanisation_si.microservices_produit_tp_j3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitInexistantException extends RuntimeException  {
	/**
	 * @param message
	 */
	public ProduitInexistantException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}	
}

