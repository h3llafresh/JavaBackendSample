package vlfl.gymexpert.application.adapters.persistence.personalCard;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.port.out.personalCard.LoadPersonalCardPort;
import vlfl.gymexpert.application.port.out.personalCard.UpdatePersonalCardPort;
import vlfl.gymexpert.application.util.HibernateUtil;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

@Component
class PersonalCardPersistenceAdapter implements LoadPersonalCardPort, UpdatePersonalCardPort {


    private final SpringDataPersonalCardRepository repository;
    private final PersonalCardMapper personalCardMapper;

    public PersonalCardPersistenceAdapter(SpringDataPersonalCardRepository repository, PersonalCardMapper personalCardMapper) {
        this.repository = repository;
        this.personalCardMapper = personalCardMapper;
    }

    @Override
    public PersonalCard loadPersonalCard(Long ID) {
        PersonalCardJpaEntity personalCardJpa = repository.findById(ID)
            .orElseThrow(EntityNotFoundException::new);
        return personalCardMapper.mapToDomainEntity(personalCardJpa);
    }

    @Override
    public void updatePersonalCard(PersonalCard newData) {
        Long personalCardID = newData.getID();
        if (repository.existsById(personalCardID)) {
            PersonalCardJpaEntity personalCard = repository.getById(personalCardID);
            personalCard.setExpirationDate(newData.getExpirationDate());
            personalCard.setAttendancesNumber(newData.getAttendancesNumber());
            personalCard.setRegularCustomerDiscount(newData.getRegularCustomerDiscount());
            repository.save(personalCard);
        } else
            throw new ServerErrorException((String.format("User with specified ID (%d) not found", personalCardID)), new SQLException());
    }
}
