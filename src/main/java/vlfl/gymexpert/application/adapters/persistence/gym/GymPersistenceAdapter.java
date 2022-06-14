package vlfl.gymexpert.application.adapters.persistence.gym;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerErrorException;
import vlfl.gymexpert.application.domain.Gym;
import vlfl.gymexpert.application.port.out.gym.DeleteGymPort;
import vlfl.gymexpert.application.port.out.gym.LoadGymPort;
import vlfl.gymexpert.application.port.out.gym.SaveGymPort;
import vlfl.gymexpert.application.port.out.gym.UpdateGymPort;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GymPersistenceAdapter implements
    LoadGymPort,
    SaveGymPort,
    UpdateGymPort,
    DeleteGymPort {

    private final SpringDataGymRepository repository;
    private final GymMapper gymMapper;

    public GymPersistenceAdapter(SpringDataGymRepository repository, GymMapper gymMapper) {
        this.repository = repository;
        this.gymMapper = gymMapper;
    }

    @Override
    public Gym loadGym(Long ID) {
        GymJpaEntity gymJpa = repository.findById(ID)
            .orElseThrow(EntityNotFoundException::new);
        return gymMapper.mapToDomainEntity(gymJpa);
    }

    @Override
    public List<Gym> loadAllGyms() {
        List<GymJpaEntity> gymsJpa = repository.findAll();
        ArrayList<Gym> gyms = new ArrayList<>();
        for (GymJpaEntity gymJpa : gymsJpa) {
            gyms.add(gymMapper.mapToDomainEntity(gymJpa));
        }
        return gyms;
    }

    @Override
    public void saveGym(Gym gym) {
        repository.save(gymMapper.mapToJpaEntity(gym));
    }

    @Override
    public void updateGym(Gym gym) {
        Long gymID = gym.getID();
        if (repository.existsById(gymID)) {
            repository.save(gymMapper.mapToJpaEntity(gym));
        } else
            throw new ServerErrorException((String.format("Gym with specified ID (%d) not found", gymID)), new SQLException());
    }

    @Override
    public void deleteGym(Long ID) {
        repository.deleteById(ID);
    }
}
