package vlfl.gymexpert.application.services;

import org.springframework.stereotype.Service;
import vlfl.gymexpert.application.domain.User;
import vlfl.gymexpert.application.port.in.user.CreateUserUseCase;
import vlfl.gymexpert.application.port.in.user.DeleteUserUseCase;
import vlfl.gymexpert.application.port.in.user.GetUserUseCase;
import vlfl.gymexpert.application.port.in.user.UpdateUserUseCase;
import vlfl.gymexpert.application.port.out.user.LoadUserPort;
import vlfl.gymexpert.application.port.out.user.SaveUserPort;

@Service
public class UserService implements CreateUserUseCase, DeleteUserUseCase, GetUserUseCase, UpdateUserUseCase {

    private final LoadUserPort loadUserPort;
    private final SaveUserPort saveUserPort;

    public UserService(LoadUserPort loadUserPort, SaveUserPort saveUserPort) {
        this.loadUserPort = loadUserPort;
        this.saveUserPort = saveUserPort;
    }

    @Override
    public User getUser(Long ID) {
        User user = loadUserPort.loadUser(ID);
        System.out.println(user.toString());
        return loadUserPort.loadUser(ID);
    }

    @Override
    public boolean deleteUser(Long ID) {
        //TODO not yet implemented
        return false;
    }

    @Override
    public boolean create(User user) {
        return saveUserPort.saveUser(user);
    }
}
