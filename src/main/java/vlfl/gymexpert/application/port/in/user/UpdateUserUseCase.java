package vlfl.gymexpert.application.port.in.user;

import vlfl.gymexpert.application.domain.User;

public interface UpdateUserUseCase {
    void updateUser(User newData);
}
