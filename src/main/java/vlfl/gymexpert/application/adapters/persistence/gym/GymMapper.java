package vlfl.gymexpert.application.adapters.persistence.gym;

import org.springframework.stereotype.Component;
import vlfl.gymexpert.application.domain.Gym;

@Component
public class GymMapper {
    Gym mapToDomainEntity(
        GymJpaEntity gymJpaEntity
    ) {
        return Gym.builder()
            .id(gymJpaEntity.getID())
            .address(gymJpaEntity.getAddress())
            .phoneNumber(gymJpaEntity.getPhoneNumber())
            .workingHours(gymJpaEntity.getWorkingHours())
            .build();
    }

    GymJpaEntity mapToJpaEntity(
        Gym gymDomainEntity
    ) {
        return new GymJpaEntity(
            gymDomainEntity.getAddress(),
            gymDomainEntity.getPhoneNumber(),
            gymDomainEntity.getWorkingHours()
        );
    }

}
