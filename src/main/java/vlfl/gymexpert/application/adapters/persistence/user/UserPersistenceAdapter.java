package vlfl.gymexpert.application.adapters.persistence.user;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;
import vlfl.gymexpert.application.adapters.persistence.personalCard.PersonalCardJpaEntity;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.out.user.DeleteUserPort;
import vlfl.gymexpert.application.port.out.user.LoadUserPort;
import vlfl.gymexpert.application.port.out.user.SaveUserPort;
import vlfl.gymexpert.application.port.out.user.UpdateUserPort;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserPersistenceAdapter implements LoadUserPort, SaveUserPort, UpdateUserPort, DeleteUserPort {

    private final SpringDataUserRepository repository;
    private final UserMapper userMapper;

    public UserPersistenceAdapter(SpringDataUserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public User loadUser(Long ID) {
        UserJpaEntity userJpa = repository.findById(ID)
            .orElseThrow(EntityNotFoundException::new);
        return userMapper.mapToDomainEntity(userJpa);
    }

    @Override
    public List<User> loadAllUsers() {
        List<UserJpaEntity> usersJpa = repository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for (UserJpaEntity userJpa: usersJpa) {
            users.add(userMapper.mapToDomainEntity(userJpa));
        }
        return users;
    }

    @Override
    public void saveUserWithPersonalCard(User user, PersonalCard personalCard) {
        repository.save(userMapper.mapToJpaEntity(user, personalCard));
    }

    @Override
    public void updateUser(User user) {
        Long userID = user.getID();
        if (repository.existsById(userID)) {
            PersonalCardJpaEntity personalCard = repository.getById(userID).getPersonalCard();
            repository.save(userMapper.mapToJpaEntity(user, personalCard));
        } else throw new ServerErrorException((String.format("User with specified ID (%d) not found", userID)), new SQLException());
    }

    @Override
    public void deleteUser(Long ID) {
        repository.deleteById(ID);
    }
}
