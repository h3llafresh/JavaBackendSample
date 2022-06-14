package vlfl.gymexpert.application.services;

import org.springframework.stereotype.Service;
import vlfl.gymexpert.application.domain.PersonalCard;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.in.user.*;
import vlfl.gymexpert.application.port.out.user.DeleteUserPort;
import vlfl.gymexpert.application.port.out.user.LoadUserPort;
import vlfl.gymexpert.application.port.out.user.SaveUserPort;
import vlfl.gymexpert.application.port.out.user.UpdateUserPort;

import java.util.List;

@Service
public class UserService implements CreateUserWithPersonalCardUseCase, DeleteUserUseCase, GetUserUseCase, UpdateUserUseCase, GetAllUsersUseCase {

    private final SaveUserPort saveUserPort;
    private final LoadUserPort loadUserPort;
    private final UpdateUserPort updateUserPort;
    private final DeleteUserPort deleteUserPort;

    public UserService(
        SaveUserPort saveUserPort,
        LoadUserPort loadUserPort,
        UpdateUserPort updateUserPort,
        DeleteUserPort deleteUserPort
    ) {
        this.saveUserPort = saveUserPort;
        this.loadUserPort = loadUserPort;
        this.updateUserPort = updateUserPort;
        this.deleteUserPort = deleteUserPort;
    }

    @Override
    public void createUserWithPersonalCard(User user, PersonalCard personalCard) {
        saveUserPort.saveUserWithPersonalCard(user, personalCard);
    }

    @Override
    public User getUser(Long ID) {
        return loadUserPort.loadUser(ID);
    }

    @Override
    public void updateUser(User newUserData) {
        updateUserPort.updateUser(newUserData);
    }

    @Override
    public void deleteUser(Long ID) {
        deleteUserPort.deleteUser(ID);
    }

    @Override
    public List<User> getUsers() {
        return loadUserPort.loadAllUsers();
    }
}
