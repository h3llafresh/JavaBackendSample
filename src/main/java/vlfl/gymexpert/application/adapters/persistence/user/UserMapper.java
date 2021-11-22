package vlfl.gymexpert.application.adapters.persistence.user;

import org.springframework.stereotype.Component;
import vlfl.gymexpert.application.adapters.persistence.personalCard.PersonalCardJpaEntity;
import vlfl.gymexpert.application.adapters.persistence.personalCard.PersonalCardMapper;
import vlfl.gymexpert.application.domain.PersonalCard;
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
            .personalCardID(userJpaEntity.getPersonalCard().getId())
            .build();
    }

    UserJpaEntity mapToJpaEntity(
        User userDomainEntity, PersonalCard personalCard
    ) {
        PersonalCardJpaEntity personalCardJpaEntity = new PersonalCardMapper().mapToJpaEntity(personalCard);
        UserJpaEntity userJpaEntity = new UserJpaEntity(
            userDomainEntity.getFirstName(),
            userDomainEntity.getLastName(),
            userDomainEntity.getBirthDate(),
            userDomainEntity.getMoneyBalance(),
            personalCardJpaEntity
        );
        personalCardJpaEntity.setUser(userJpaEntity);
        return userJpaEntity;
    }

    UserJpaEntity mapToJpaEntity(
        User userDomainEntity, PersonalCardJpaEntity personalCardJpaEntity
    ) {
        return new UserJpaEntity(
            userDomainEntity.getFirstName(),
            userDomainEntity.getLastName(),
            userDomainEntity.getBirthDate(),
            userDomainEntity.getMoneyBalance(),
            personalCardJpaEntity
        );
    }
}
