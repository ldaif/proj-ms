/**
 * 
 */
package com.urbanisation_si.microservices_clientui.beans;

import javax.validation.constraints.NotNull;

/**
 * @author Patrice
 *
 */
public class ContratBean {
	
	private Integer id;

	private Long numeroContrat;
	
//    @JsonFormat(pattern="yyyy-MM-dd")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private String dateDebut;
    

	private Long numeroAssure;
	

	private Long numeroProduit;

	public Long getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
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

	public ContratBean(Integer id, @NotNull Long numeroContrat, String dateDebut, @NotNull Long numeroAssure,
			@NotNull Long numeroProduit) {
		super();
		this.numeroContrat = numeroContrat;
		this.dateDebut = dateDebut;
		this.numeroAssure = numeroAssure;
		this.numeroProduit = numeroProduit;
	}

	public ContratBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ContratBean [numeroContrat=" + numeroContrat + ", dateDebut=" + dateDebut
				+ ", numeroAssure=" + numeroAssure + ", numeroProduit=" + numeroProduit + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
}

