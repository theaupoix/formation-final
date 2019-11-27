package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;
import sopra.formation.model.Module;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {
	
	@Query("select c from Filiere c left join fetch c.referent f where f.id = :id")
	List<Filiere> findByFormateur(@Param("id") Long id);

}

