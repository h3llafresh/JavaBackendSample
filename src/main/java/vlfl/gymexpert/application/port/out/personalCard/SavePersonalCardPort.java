package vlfl.gymexpert.application.port.out.personalCard;

import vlfl.gymexpert.application.adapters.persistence.personalCard.PersonalCardJpaEntity;
import vlfl.gymexpert.application.domain.PersonalCard;

public interface SavePersonalCardPort {
    void savePersonalCard(PersonalCard personalCard);
}
