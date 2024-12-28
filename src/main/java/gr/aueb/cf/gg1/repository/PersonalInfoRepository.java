package gr.aueb.cf.gg1.repository;

import gr.aueb.cf.gg1.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer>, JpaSpecificationExecutor<PersonalInfo> {
    Optional<PersonalInfo> findByGamingId(String gamingId);
}
