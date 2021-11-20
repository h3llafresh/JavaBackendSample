package vlfl.gymexpert.application.adapters.persistence.user;

import org.springframework.stereotype.Component;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.out.user.LoadUserPort;
import vlfl.gymexpert.application.port.out.user.SaveUserPort;

import javax.persistence.EntityNotFoundException;

@Component
public class UserPersistenceAdapter implements LoadUserPort, SaveUserPort {

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
    public boolean saveUser(User user) {
//        User savedUser = repository.save(user);
//        return savedUser != null;
        return false;
    }
}
