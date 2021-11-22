package vlfl.gymexpert.application.port.in.user;

import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.domain.User;

public interface CreateUserWithPersonalCardUseCase {
    void createUserWithPersonalCard(User user, PersonalCard personalCard);
}
