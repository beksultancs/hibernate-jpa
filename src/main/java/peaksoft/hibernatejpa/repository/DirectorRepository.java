package peaksoft.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.hibernatejpa.model.entity.Director;

/**
 * @author Beksultan
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
