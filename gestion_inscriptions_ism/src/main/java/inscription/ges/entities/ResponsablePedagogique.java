package inscription.ges.entities;

public class ResponsablePedagogique extends User{

    public ResponsablePedagogique(String login, String password) {
        super(login, password);
        role=Role.ResponsablePedagogique;
    }
    public ResponsablePedagogique(String login, String password, Role role) {
        super(login, password);
        role=Role.ResponsablePedagogique;
    }
    
   
    
}
