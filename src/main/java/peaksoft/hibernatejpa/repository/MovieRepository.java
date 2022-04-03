package peaksoft.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.hibernatejpa.model.entity.Movie;

/**
 * @author Beksultan
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
