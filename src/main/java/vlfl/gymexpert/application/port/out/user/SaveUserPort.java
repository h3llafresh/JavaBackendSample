package vlfl.gymexpert.application.port.out.user;

import vlfl.gymexpert.application.domain.User;

public interface SaveUserPort {
    boolean saveUser(User user);
}
