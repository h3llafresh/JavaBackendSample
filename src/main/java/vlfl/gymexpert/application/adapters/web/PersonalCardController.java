package vlfl.gymexpert.application.adapters.web;

import org.springframework.web.bind.annotation.*;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.port.in.personalCard.GetPersonalCardUseCase;
import vlfl.gymexpert.application.port.in.personalCard.UpdatePersonalCardUseCase;

@RestController
@RequestMapping(value = "/personalCard")
public class PersonalCardController {

    private final GetPersonalCardUseCase getPersonalCardUseCase;
    private final UpdatePersonalCardUseCase updatePersonalCardUsecase;

    public PersonalCardController(
        GetPersonalCardUseCase getPersonalCardUseCase,
        UpdatePersonalCardUseCase updatePersonalCardUsecase) {
        this.getPersonalCardUseCase = getPersonalCardUseCase;
        this.updatePersonalCardUsecase = updatePersonalCardUsecase;
    }

    @GetMapping(value = "get/{id}")
    PersonalCard getPersonalCard(@PathVariable Long id) {
        return getPersonalCardUseCase.getPersonalCard(id);
    }

    @PutMapping(value = "update/{id}")
    void updatePersonalCard(
        @PathVariable Long id,
        @RequestParam String expirationDate,
        @RequestParam int attendancesNumber,
        @RequestParam int regularCustomerDiscount
    ) {
        updatePersonalCardUsecase.updatePersonalCard(
            PersonalCard.builder()
                .id(id)
                .expirationDate(expirationDate)
                .attendancesNumber(attendancesNumber)
                .regularCustomerDiscount(regularCustomerDiscount)
                .build()
        );
    }
}
