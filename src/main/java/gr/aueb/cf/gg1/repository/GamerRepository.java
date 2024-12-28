package gr.aueb.cf.gg1.repository;

import gr.aueb.cf.gg1.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface GamerRepository extends JpaRepository<Gamer, Long>, JpaSpecificationExecutor<Gamer> {
    Optional<Gamer> findByUserId(Long id);
    Optional<Gamer> findByUuid(String uuid);
}
