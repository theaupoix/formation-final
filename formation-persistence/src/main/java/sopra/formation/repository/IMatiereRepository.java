package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.MatiereId;

public interface IMatiereRepository extends JpaRepository<Matiere, MatiereId> {
	@Query("select distinct m.matiere from Module m join m.filiere f where f = :filiere")
	List<Matiere> findAllByFiliere(@Param("filiere") Filiere filiere);

	@Query("select m from Matiere m  left join fetch m.formateurs f where f.id = :id")
	List<Matiere> findAllByFormateur(@Param("id") Long id);

}
