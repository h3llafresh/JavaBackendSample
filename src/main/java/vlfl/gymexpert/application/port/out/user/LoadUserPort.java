package vlfl.gymexpert.application.port.out.user;

import vlfl.gymexpert.application.domain.User;

import java.util.List;

public interface LoadUserPort {
    User loadUser(Long ID);
    List<User> loadAllUsers();
}
