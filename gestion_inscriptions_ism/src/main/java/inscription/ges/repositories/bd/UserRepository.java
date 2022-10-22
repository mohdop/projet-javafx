package inscription.ges.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import inscription.ges.core.MysqlDB;
import inscription.ges.entities.Role;
import inscription.ges.entities.User;
import inscription.ges.repositories.IUserRepository;

public class UserRepository extends MysqlDB  implements IUserRepository{

    private final String SQL_CONNECT="SELECT * FROM `user` WHERE `login` LIKE ? AND `password` LIKE ?";
    
    
    @Override
    public User findUserByLoginAndPassword(String login,String password) {
        User user=null;
        this.ouvrirConnexion();
        try {
            ps = conn.prepareStatement(SQL_CONNECT);
            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("role").compareTo("ResponsablePedagogique")==0? Role.ResponsablePedagogique:Role.Attache);
            }
            
        } catch (SQLException e) {
            System.out.println("erreur");
            e.printStackTrace();
            
        }
        this.fermerConnexion();
        return user;
    }
    
}
