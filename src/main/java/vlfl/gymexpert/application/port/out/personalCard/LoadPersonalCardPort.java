package vlfl.gymexpert.application.port.out.personalCard;

import vlfl.gymexpert.application.domain.PersonalCard;

public interface LoadPersonalCardPort {
    PersonalCard loadPersonalCard(Long ID);
}
