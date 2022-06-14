package vlfl.gymexpert.application.services;

import org.springframework.stereotype.Service;
import vlfl.gymexpert.application.domain.Gym;
import vlfl.gymexpert.application.port.in.gym.*;
import vlfl.gymexpert.application.port.out.gym.DeleteGymPort;
import vlfl.gymexpert.application.port.out.gym.LoadGymPort;
import vlfl.gymexpert.application.port.out.gym.SaveGymPort;
import vlfl.gymexpert.application.port.out.gym.UpdateGymPort;

import java.util.List;

@Service
public class GymService implements
    CreateGymUseCase,
    DeleteGymUseCase,
    UpdateGymUseCase,
    GetGymUseCase,
    GetAllGymsUseCase
{

    private final SaveGymPort saveGymPort;
    private final LoadGymPort loadGymPort;
    private final UpdateGymPort updateGymPort;
    private final DeleteGymPort deleteGymPort;

    public GymService(
        SaveGymPort saveGymPort,
        LoadGymPort loadGymPort,
        UpdateGymPort updateGymPort,
        DeleteGymPort deleteGymPort) {
        this.saveGymPort = saveGymPort;
        this.loadGymPort = loadGymPort;
        this.updateGymPort = updateGymPort;
        this.deleteGymPort = deleteGymPort;
    }

    @Override
    public void createGym(Gym gym) {
        saveGymPort.saveGym(gym);
    }

    @Override
    public void deleteGym(Long id) {
        deleteGymPort.deleteGym(id);
    }

    @Override
    public Gym getGym(Long id) {
        return loadGymPort.loadGym(id);
    }

    @Override
    public void updateGym(Gym gym) {
        updateGymPort.updateGym(gym);
    }

    @Override
    public List<Gym> getAllGyms() {
        return loadGymPort.loadAllGyms();
    }
}
