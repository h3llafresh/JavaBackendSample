package vlfl.gymexpert.application.port.out.user;

import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.domain.User;

public interface SaveUserPort {
    void saveUserWithPersonalCard(User user, PersonalCard personalCard);
}
