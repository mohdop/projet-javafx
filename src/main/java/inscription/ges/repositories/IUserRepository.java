package inscription.ges.repositories;

import inscription.ges.entities.User;

public interface IUserRepository {
    public User findUserByLoginAndPassword(String login,String password);
}
