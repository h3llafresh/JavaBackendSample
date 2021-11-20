package vlfl.gymexpert.application.port.out.user;

import vlfl.gymexpert.application.domain.User;

public interface LoadUserPort {
    User loadUser(Long ID);
}
