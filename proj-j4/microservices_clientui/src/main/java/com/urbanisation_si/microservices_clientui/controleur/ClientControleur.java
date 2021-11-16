/**
 * 
 */
package com.urbanisation_si.microservices_clientui.controleur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.urbanisation_si.microservices_clientui.beans.AssureBean;
import com.urbanisation_si.microservices_clientui.beans.ContratBean;
import com.urbanisation_si.microservices_clientui.beans.ProduitBean;
import com.urbanisation_si.microservices_clientui.proxies.MicroserviceAssureProxy;
import com.urbanisation_si.microservices_clientui.proxies.MicroserviceContratProxy;
import com.urbanisation_si.microservices_clientui.proxies.MicroserviceProduitProxy;

/**
 * @author Patrice
 *
 */
// J4 - 1
@Controller
public class ClientControleur {

	//J4 - 8
	@Autowired    
	private MicroserviceAssureProxy mAssureProxy; 

	//J4 - 10
	@Autowired
	private MicroserviceContratProxy mContratProxy;
	@Autowired
	private MicroserviceProduitProxy mProduitProxy;
	//J4 - 10

	Logger log = LoggerFactory.getLogger(this.getClass());  

	@GetMapping("/")        
	public String accueil(Model model){
		log.info("---------------------------- Envoi requête vers Accueil"); 

		//J4 - 8
//		    	List<AssureBean>  assures = mAssureProxy.getAllAssures();   
//		    	model.addAttribute("assures", assures);
		//J4 - 8

//		//J4 - 10
		// A faire quand on commence le formulaire
		AssureBean assureBean = new AssureBean();
		model.addAttribute("assureBean", assureBean);
//		//J4 - 10

		return "Accueil";    
	}

	//J4 - 9
	@GetMapping(path="/Assure/numeroAssure/{numeroAssure}")    
	public String rechercherAssureNumeroAssure(@PathVariable Long numeroAssure, Model model) {    

		List<AssureBean> assures =   mAssureProxy.rechercherAssureNumeroAssure(numeroAssure);

		model.addAttribute("assures", assures);
		return "DetailAssure";    
	}

	//J4 - 10
	@PostMapping(value = "/saisir-assure")
	public String saisirAssure(AssureBean assureBean, Model model){

		log.info("---------------------------- Envoi requête vers saisirAssure");

		List<AssureBean> assures =  mAssureProxy.rechercherAssureNomPrenom(assureBean.getNom(), assureBean.getPrenom());

		model.addAttribute("assures", assures);

		return "ListeAssure";
	}

	@GetMapping(path="/creer/{numeroAssure}")
	public String creer(@PathVariable Long numeroAssure, Model model) {

		ContratBean contratBean = mContratProxy.creer(numeroAssure);
		model.addAttribute("contratBean", contratBean);

		List<ProduitBean> produits = mProduitProxy.listerLesProduits();
		model.addAttribute("produits", produits);

		return "ListeProduit";    
	}
	
	@GetMapping(path="/creerContrat/{numeroAssure}")
	public String creerContrat(@PathVariable Long numeroAssure, Model model) {

		ContratBean contratBean = new ContratBean();
		// TODO   
		// Mettre en place une règle métier qui renvoie un nouveau numéro de contrat
		contratBean.setNumeroContrat(Calendar.getInstance().getTimeInMillis());
		
		contratBean.setId(12345);
		// TODO
		// ainsi que la date du jour
		Date dateDuJour = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateDuJourString = df.format(dateDuJour);  
//		String sdate = "2021-04-16";
		// Conversion inverse String -> Date si besoin
//		try {
//			Date date = df.parse(sdate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		contratBean.setDateDebut(dateDuJourString);
		contratBean.setNumeroProduit(0L);
		contratBean.setNumeroAssure(numeroAssure);
		log.info("---------------------------- Envoi requête vers creerContrat(");
		mContratProxy.creerContrat(contratBean);
		model.addAttribute("contratBean", contratBean);

		List<ProduitBean> produits = mProduitProxy.listerLesProduits();
		model.addAttribute("produits", produits);

		return "ListeProduit";    
	}


	@GetMapping(path="/affecterNumeroProduit/{numeroAssure}/{numeroProduit}")
	public String affecterNumeroProduit(@PathVariable Long numeroAssure, @PathVariable Long numeroProduit, Model model) {

		log.info("-----------------ClientControleur > affecterNumeroProduit > numeroAssure : " + numeroAssure + " numeroProduit : " + numeroProduit);
		ContratBean contratAffecte = mContratProxy.affecterNumeroProduit(numeroAssure, numeroProduit);
		log.info("-----------------ClientControleur > affecterNumeroProduit > mContratProxy.affecterNumeroProduit : " + contratAffecte);
		model.addAttribute("contratAffecte", contratAffecte);

		return "FinaliserContrat";    
	}

	@GetMapping(path = "/finaliserContrat/{numeroAssure}")
	public String finaliserContrat(@PathVariable Long numeroAssure, ContratBean contratAffecte, Model model) {

		log.info("-----------------ClientControleur > finaliserContrat > contratAffecte : " + contratAffecte);

		ContratBean contratFinalise =  mContratProxy.finaliserContrat(numeroAssure, contratAffecte.getNumeroContrat(), contratAffecte.getDateDebut());

		log.info("-----------------ClientControleur > finaliserContrat > mContratProxy.finaliserContrat : " + contratFinalise);

		model.addAttribute("contratFinalise", contratFinalise);

		return "ConfirmationCreationContrat";
	}

}
