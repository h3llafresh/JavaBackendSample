package vlfl.gymexpert.application.adapters.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, Long> { }
