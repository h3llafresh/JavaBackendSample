package vlfl.gymexpert.application.adapters.persistence.user;

import org.springframework.stereotype.Component;
import vlfl.gymexpert.application.domain.User;

@Component
public class UserMapper {

    User mapToDomainEntity(
        UserJpaEntity userJpaEntity
    ) {
        return User.builder()
            .id(userJpaEntity.getId())
            .firstName(userJpaEntity.getFirstName())
            .lastName(userJpaEntity.getLastName())
            .birthDate(userJpaEntity.getBirthDate())
            .moneyBalance(userJpaEntity.getMoneyBalance())
            .personalCardID(userJpaEntity.getPersonalCardId())
            .build();
    }
}
