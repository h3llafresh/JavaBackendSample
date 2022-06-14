package vlfl.gymexpert.application.port.in.user;

import vlfl.gymexpert.application.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getUsers();
}
