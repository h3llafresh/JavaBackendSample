package vlfl.gymexpert.application.adapters.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.in.user.CreateUserUseCase;
import vlfl.gymexpert.application.port.in.user.DeleteUserUseCase;
import vlfl.gymexpert.application.port.in.user.GetUserUseCase;
import vlfl.gymexpert.application.port.in.user.UpdateUserUseCase;


@RestController
@RequestMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(
        CreateUserUseCase createUserUseCase,
        GetUserUseCase getUserUseCase,
        UpdateUserUseCase updateUserUseCase,
        DeleteUserUseCase deleteUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping(value = "/create/{id}")
    void createUser(@PathVariable Long id) {
        createUserUseCase.create(
            User.builder()
                .id(id)
                .build()
        );
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable Long id) {
        return getUserUseCase.getUser(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    String deleteUser(@PathVariable Long id) {
        if (deleteUserUseCase.deleteUser(id)) {
            return "true";
        } else return "false";
    }
}
