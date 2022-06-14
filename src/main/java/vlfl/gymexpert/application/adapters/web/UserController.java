package vlfl.gymexpert.application.adapters.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.in.user.*;

import java.util.List;


@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final CreateUserWithPersonalCardUseCase createUserWithPersonalCardUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(
        CreateUserWithPersonalCardUseCase createUserWithPersonalCardUseCase,
        GetAllUsersUseCase getAllUsersUseCase,
        GetUserUseCase getUserUseCase,
        UpdateUserUseCase updateUserUseCase,
        DeleteUserUseCase deleteUserUseCase
    ) {
        this.createUserWithPersonalCardUseCase = createUserWithPersonalCardUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getUserUseCase = getUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping(value = "/create")
    void createUserWithPersonalCard(
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String birthDate,
        @RequestParam Long moneyBalance,
        @RequestParam String expirationDate,
        @RequestParam int attendancesNumber,
        @RequestParam int regularCustomerDiscount
    ) {
        createUserWithPersonalCardUseCase.createUserWithPersonalCard(
            User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .moneyBalance(moneyBalance)
                .build(),
            PersonalCard.builder()
                .expirationDate(expirationDate)
                .attendancesNumber(attendancesNumber)
                .regularCustomerDiscount(regularCustomerDiscount)
                .build()
        );
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAllUsers() {
        return getAllUsersUseCase.getUsers();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable Long id) {
        return getUserUseCase.getUser(id);
    }

    @PutMapping(value = "/update/{id}")
    void updateUser(
        @PathVariable Long id,
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String birthDate,
        @RequestParam Long moneyBalance,
        @RequestParam Long personalCardId
    ) {
        updateUserUseCase.updateUser(
            User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .moneyBalance(moneyBalance)
                .personalCardID(personalCardId)
                .build());
    }

    @DeleteMapping(value = "/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        deleteUserUseCase.deleteUser(id);
    }
}
