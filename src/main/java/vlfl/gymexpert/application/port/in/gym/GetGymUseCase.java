package vlfl.gymexpert.application.port.in.gym;

import vlfl.gymexpert.application.domain.Gym;

public interface GetGymUseCase {
    Gym getGym(Long id);
}
