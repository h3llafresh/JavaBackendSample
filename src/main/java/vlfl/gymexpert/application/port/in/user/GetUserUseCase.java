package vlfl.gymexpert.application.port.in.user;

import vlfl.gymexpert.application.domain.User;

public interface GetUserUseCase {
    User getUser(Long ID);
}
