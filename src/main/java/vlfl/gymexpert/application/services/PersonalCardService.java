package vlfl.gymexpert.application.services;

import org.springframework.stereotype.Service;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.port.in.personalCard.GetPersonalCardUseCase;
import vlfl.gymexpert.application.port.in.personalCard.UpdatePersonalCardUseCase;
import vlfl.gymexpert.application.port.out.personalCard.LoadPersonalCardPort;
import vlfl.gymexpert.application.port.out.personalCard.UpdatePersonalCardPort;

@Service
public class PersonalCardService implements GetPersonalCardUseCase, UpdatePersonalCardUseCase {

    private final LoadPersonalCardPort loadPersonalCardPort;
    private final UpdatePersonalCardPort updatePersonalCardPort;

    public PersonalCardService(
        LoadPersonalCardPort loadPersonalCardPort,
        UpdatePersonalCardPort updatePersonalCardPort
    ) {
        this.loadPersonalCardPort = loadPersonalCardPort;
        this.updatePersonalCardPort = updatePersonalCardPort;
    }

    @Override
    public PersonalCard getPersonalCard(Long ID) {
        return loadPersonalCardPort.loadPersonalCard(ID);
    }

    @Override
    public void updatePersonalCard(PersonalCard newData) {
        updatePersonalCardPort.updatePersonalCard(newData);
    }
}
