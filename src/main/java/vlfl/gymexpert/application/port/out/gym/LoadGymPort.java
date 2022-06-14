package vlfl.gymexpert.application.port.out.gym;

import vlfl.gymexpert.application.domain.Gym;

import java.util.List;

public interface LoadGymPort {
    Gym loadGym(Long ID);

    List<Gym> loadAllGyms();
}
