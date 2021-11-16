package com.urbanisation_si.microservices_contrat_tp_j3.controleur;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanisation_si.microservices_contrat_tp_j3.dao.ContratRepository;
import com.urbanisation_si.microservices_contrat_tp_j3.exceptions.ContratInexistantException;
import com.urbanisation_si.microservices_contrat_tp_j3.exceptions.CreationContratImpossibleException;
import com.urbanisation_si.microservices_contrat_tp_j3.modele.Contrat;

@RestController
@RequestMapping(path="/contrat")
public class ContratControleur {
	@Autowired
	private ContratRepository contratRepository;
	
    Logger log = LoggerFactory.getLogger(this.getClass());
	
    @PostMapping (path="/creerContrat")
    public ResponseEntity<Contrat> creerContrat(@RequestBody Contrat contrat) {
    	Contrat nouveauContrat = contratRepository.save(contrat);

        if(nouveauContrat == null) throw new CreationContratImpossibleException("Impossible de créer le contrat.");

        return new ResponseEntity<Contrat>(nouveauContrat, HttpStatus.CREATED);
    }
    
    @PostMapping (path="/creer")
    public ResponseEntity<Contrat> creer(@RequestBody Long numeroAssure) {
    	Contrat nouveauContrat = new Contrat();
    	nouveauContrat.setNumeroAssure(numeroAssure);
    	nouveauContrat = contratRepository.save(nouveauContrat);

        if(nouveauContrat == null) throw new CreationContratImpossibleException("Impossible de créer le contrat.");
        
        log.info("--------------------------- Creation du contrat de l'assuré (numéro assuré) = {}", numeroAssure);

        return new ResponseEntity<Contrat>(nouveauContrat, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/rechercherId/{id}")
    public Optional<Contrat> rechercherContratId(@PathVariable Integer id) {

        Optional<Contrat> contrat = contratRepository.findById(id);

        if(!contrat.isPresent()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrat;
    }
    
	@GetMapping(path="/rechercherNumeroContrat/{numeroContrat}")
	public List<Contrat> rechercherContratNumeroContrat(@PathVariable Long numeroContrat) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroContrat(numeroContrat);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
	
	@GetMapping(path="/rechercherNumeroAssure/{numeroAssure}")
	public List<Contrat> rechercherContratNumeroAssure(@PathVariable Long numeroAssure) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroAssure(numeroAssure);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
    
	@GetMapping(path="/rechercherNumeroProduit/{numeroProduit}")
	public List<Contrat> rechercherContratNumeroProduit(@PathVariable Long numeroProduit) {
		
		List<Contrat> contrats =  contratRepository.findByNumeroProduit(numeroProduit);
		
        if(contrats.isEmpty()) throw new ContratInexistantException("Ce contrat n'existe pas");

        return contrats;
	}
	
	   
    @GetMapping(path="/affecterNumeroProduit/{numeroAssure}/{numeroProduit}")
	public ResponseEntity<Contrat> affecterNumeroProduit(@PathVariable Long numeroAssure, @PathVariable Long numeroProduit) {
    	
    	log.info("-----------------ContratControleur > affecterNumeroProduit > numeroAssure : " + numeroAssure + " numeroProduit : " + numeroProduit);
    	
    	List<Contrat> contrats = contratRepository.findByNumeroAssure(numeroAssure);
    	
    	Contrat contrat = contrats.get(0);
    	log.info("-----------------ContratControleur > affecterNumeroProduit > findByNumeroAssure : " + contrat);
    	contrat.setNumeroProduit(numeroProduit);
    	contrat = contratRepository.save(contrat);
    	log.info("-----------------ContratControleur > affecterNumeroProduit > contrat : " + contrat);
        if(contrat == null) throw new CreationContratImpossibleException("Impossible de créer le contrat.");

        return new ResponseEntity<Contrat>(contrat, HttpStatus.CREATED);
    }
	
    @GetMapping(path="/finaliserContrat/{numeroAssure}/{numeroContrat}/{dateDebut}")
	public ResponseEntity<Contrat> finaliserContrat(@PathVariable Long numeroAssure, @PathVariable Long numeroContrat, 
			@PathVariable  String dateDebut) {
    	
    	log.info("-----------------ContratControleur > finaliserContrat > numeroAssure : " + numeroAssure + " numeroContrat : " + numeroContrat + " dateDebut " + dateDebut);
    	
    	List<Contrat> contrats = contratRepository.findByNumeroAssure(numeroAssure);
    	
    	// On suppose qu'un assure n'a qu'un seul contrat.
    	Contrat contrat = contrats.get(0);
    	contrat.setNumeroContrat(numeroContrat);
//    	try {
//    		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);  
//    		contrat.setDateDebut(date);
//    	} catch (Exception e) {
//    		
//    	}
    	LocalDate dateContrat= LocalDate.parse(dateDebut);
    	contrat.setDateDebut(dateContrat);
    	contrat = contratRepository.save(contrat);
    	log.info("-----------------ContratControleur > finaliserContrat > contrat : " + contrat);

        if(contrat == null) throw new CreationContratImpossibleException("Impossible de créer le contrat.");

        return new ResponseEntity<Contrat>(contrat, HttpStatus.CREATED);
    }
	
	/**
	 * 
	 */
	public ContratControleur() {
		// TODO Auto-generated constructor stub
	}

}

