package vlfl.gymexpert.application.adapters.persistence.gym;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataGymRepository extends JpaRepository<GymJpaEntity, Long> {
}
