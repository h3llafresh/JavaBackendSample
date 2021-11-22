package vlfl.gymexpert.application.port.in.personalCard;

import vlfl.gymexpert.application.domain.PersonalCard;

public interface GetPersonalCardUseCase {
    PersonalCard getPersonalCard(Long ID);
}
