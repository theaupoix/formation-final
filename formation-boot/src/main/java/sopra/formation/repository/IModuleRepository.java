package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.MatiereId;
import sopra.formation.model.Module;

public interface IModuleRepository extends JpaRepository<Module, Integer> {
	
	@Query("select m from Module m left join fetch m.formateur f where f.id = :id")
	List<Module> findByFormateur(@Param("id") Long id);
	
	@Query("select m from Module m left join m.matiere s where s.id = :id")
	List<Module> findByMatiere(@Param("id") MatiereId id);
	
}
