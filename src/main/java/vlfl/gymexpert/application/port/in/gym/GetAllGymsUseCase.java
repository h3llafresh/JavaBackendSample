package vlfl.gymexpert.application.port.in.gym;

import vlfl.gymexpert.application.domain.Gym;

import java.util.List;

public interface GetAllGymsUseCase {
    List<Gym> getAllGyms();
}
