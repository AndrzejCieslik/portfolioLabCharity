package pl.coderslab.charity.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    List<Institution> findAllByNameLikeIgnoreCase(String name) ;
    List<Institution> findAllByName(String name);
    Optional<Institution> findByName(String name);
    List<Institution> findByNameIsStartingWithOrderById(String name);
}
