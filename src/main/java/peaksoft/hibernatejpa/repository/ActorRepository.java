package peaksoft.hibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.hibernatejpa.model.entity.Actor;

/**
 * @author Beksultan
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
