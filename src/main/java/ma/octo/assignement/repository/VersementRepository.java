package ma.octo.assignement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.octo.assignement.domain.Versement;


@Repository
public interface VersementRepository extends JpaRepository<Versement, Long>{

}
