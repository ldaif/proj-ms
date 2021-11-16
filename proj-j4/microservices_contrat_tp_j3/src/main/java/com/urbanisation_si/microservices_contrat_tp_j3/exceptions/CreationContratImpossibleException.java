package com.urbanisation_si.microservices_contrat_tp_j3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)    
public class CreationContratImpossibleException extends RuntimeException {

	/**
	 * 
	 */
	public CreationContratImpossibleException(String message) {
		super(message);
	}

}

