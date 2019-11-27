package sopra.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Module;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IModuleRepository;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/formateur")
public class FormateurController {
	@Autowired
	private IPersonneRepository personneRepo;
	
	@Autowired
	private IModuleRepository moduleRepo;

	@GetMapping("")
	@JsonView(Views.ViewFormateur.class)
	public List<Formateur> list() {
		List<Formateur> formateur = personneRepo.findAllFormateur();
		return formateur;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public Formateur find(@PathVariable Long id) {
		Formateur formateur = (Formateur) personneRepo.findById(id).get();

		return formateur;
	}
	
	@GetMapping("/{id}/module")
	@JsonView(Views.ViewModule.class)
	public List<Module> findModule(@PathVariable Long id) {
		List<Module> modules = moduleRepo.findByFormateur(id);

		return modules;
	}
	
//	@GetMapping("/{id}/filiere")
//	@JsonView(Views.ViewFiliere.class)
//	public List<Filiere> findFiliere(@PathVariable Long id) {
//		Formateur formateur = (Formateur) personneRepo.findWithFiliere(id);
//
//		return formateur.getFilieres()();
//	}

	@PostMapping("")
	@JsonView(Views.ViewFormateur.class)
	public Formateur create(@RequestBody Formateur formateur) {
		return personneRepo.save(formateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public Formateur update(@RequestBody Formateur formateur, @PathVariable Long id) {
		return personneRepo.save(formateur);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneRepo.deleteById(id);
	}
}
