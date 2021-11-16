package com.urbanisation_si.microservices_contrat_tp_j3.modele;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity    
public class Contrat {
	
	@Id        
	@GeneratedValue(strategy=GenerationType.AUTO)        
	private Integer id;
   
	private Long numeroContrat;     
	
//    @JsonFormat(pattern="yyyy-MM-dd")    
//    private Date dateDebut;
    
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;
        
	private Long numeroAssure;
	   
	private Long numeroProduit;
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Long getNumeroContrat() {
		return numeroContrat;
	}



	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}



	public LocalDate getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Long getNumeroAssure() {
		return numeroAssure;
	}



	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}



	public Long getNumeroProduit() {
		return numeroProduit;
	}



	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}



	/**
	 * 
	 */
	public Contrat() {
		// TODO Auto-generated constructor stub
	}

}

