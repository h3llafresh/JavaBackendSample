package vlfl.gymexpert.application.adapters.persistence.personalCard;

import org.springframework.stereotype.Component;
import vlfl.gymexpert.application.domain.PersonalCard;

@Component
public class PersonalCardMapper {

    public PersonalCard mapToDomainEntity(
        PersonalCardJpaEntity personalCardJpaEntity
    ) {
        return PersonalCard.builder()
            .id(personalCardJpaEntity.getId())
            .expirationDate(personalCardJpaEntity.getExpirationDate())
            .attendancesNumber(personalCardJpaEntity.getAttendancesNumber())
            .regularCustomerDiscount(personalCardJpaEntity.getRegularCustomerDiscount())
            .build();
    }

    public PersonalCardJpaEntity mapToJpaEntity(
        PersonalCard personalCard
    ) {
        return new PersonalCardJpaEntity(
            personalCard.getExpirationDate(),
            personalCard.getAttendancesNumber(),
            personalCard.getRegularCustomerDiscount()
        );
    }
}
