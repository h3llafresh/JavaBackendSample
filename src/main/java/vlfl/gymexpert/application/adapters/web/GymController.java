package vlfl.gymexpert.application.adapters.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vlfl.gymexpert.application.domain.Gym;
import vlfl.gymexpert.application.port.in.gym.CreateGymUseCase;
import vlfl.gymexpert.application.port.in.gym.DeleteGymUseCase;
import vlfl.gymexpert.application.port.in.gym.GetGymUseCase;
import vlfl.gymexpert.application.port.in.gym.UpdateGymUseCase;

@Controller
@RequestMapping
public class GymController {

    private final CreateGymUseCase createGymUseCase;
    private final GetGymUseCase getGymUseCase;
    private final UpdateGymUseCase updateGymUseCase;
    private final DeleteGymUseCase deleteGymUseCase;

    public GymController(
        CreateGymUseCase createGymUseCase,
        GetGymUseCase getGymUseCase,
        UpdateGymUseCase updateGymUseCase,
        DeleteGymUseCase deleteGymUseCase
    ) {
        this.createGymUseCase = createGymUseCase;
        this.getGymUseCase = getGymUseCase;
        this.updateGymUseCase = updateGymUseCase;
        this.deleteGymUseCase = deleteGymUseCase;
    }

    @PostMapping(value = "/create")
    void createGym(
        @RequestParam String address,
        @RequestParam String phoneNumber,
        @RequestParam String workingHours
    ) {
        createGymUseCase.createGym(
            Gym.builder()
                .address(address)
                .phoneNumber(phoneNumber)
                .workingHours(workingHours)
                .build()
        );
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Gym getGym(@PathVariable Long id) {
        return getGymUseCase.getGym(id);
    }

    @PutMapping(value = "/update/{id}")
    void updateGym(
        @PathVariable Long id,
        @RequestParam String address,
        @RequestParam String phoneNumber,
        @RequestParam String workingHours
    ) {
        updateGymUseCase.updateGym(
            Gym.builder()
                .id(id)
                .address(address)
                .phoneNumber(phoneNumber)
                .workingHours(workingHours)
                .build()
        );
    }

    @DeleteMapping(value = "/delete/{id}")
    void deleteGym(@PathVariable Long id) {
        deleteGymUseCase.deleteGym(id);
    }
}
